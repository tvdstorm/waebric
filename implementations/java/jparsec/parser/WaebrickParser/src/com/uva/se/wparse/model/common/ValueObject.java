/*
 * File			: ValueObject.java
 * Project		: WaebrickParser
 * 				: Waebrick Parser, practicum opdracht Software Construction
 * 
 * Author		: M. Wullink, L. Vinke, M. v.d. Laar
 * 
 * Description	:
 * 
 * 
 * Change history
 * -----------------------------------------------------------
 * Date			Change				 
 * -----------------------------------------------------------
 * 07-05-2009	Initial version.
 * 
 * 
 */
package com.uva.se.wparse.model.common;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Base class that implements {@link Object#equals(Object)}, {@link Object#hashCode()} and
 * {@code Object#toString()} on final fields.
 * 
 * @author Ben Yu
 */
public abstract class ValueObject {
	
  public static final String OUTPUT_EMPTY_ELEMENT	= "";  
  
  public static final String OUTPUT_QUOTE	 		= "\"";
  
  public static final String OUTPUT_BLOCK_EMPTY		= "";
  public static final String OUTPUT_BLOCK_BEGIN		= "(";
  public static final String OUTPUT_BLOCK_SEPARATOR	= ",";
  public static final String OUTPUT_BLOCK_END 		= ")";
  
  public static final String OUTPUT_LIST_EMPTY		= "empty";  
  public static final String OUTPUT_LIST_BEGIN 		= "["; 
  public static final String OUTPUT_LIST_SEPARATOR 	= ",";
  public static final String OUTPUT_LIST_END 		= "]";
  
  
  private volatile List<Object> fieldValues = null;
  
  private List<Object> valueList() {
    if (fieldValues == null) {
      fieldValues = Collections.unmodifiableList(toValueList(this, getValueFields(getClass())));
    }
    return fieldValues;
  }
  
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    return valueList().equals(((ValueObject) obj).valueList());
  }

  @Override public int hashCode() {
    return valueList().hashCode();
  }

  @Override public String toString() {
    StringBuilder buf = new StringBuilder(getClass().getSimpleName());
    buf.append(" {");
    Field[] fields = getValueFields(getClass());
    int i = 0;
    for (Object value : valueList()) {
      if (i > 0) {
        buf.append(", ");
      }
      buf.append(fields[i++].getName()).append('=').append(value);
    }
    buf.append('}');
    return buf.toString();
  }



  private static final Comparator<Field> NAME_ORDER = new Comparator<Field>() {
    public int compare(Field field1, Field field2) {
      return field1.getName().compareTo(field2.getName());
    }
  };
  
  private static final ConcurrentMap<Class<?>, Field[]> valueFieldMap =
      new ConcurrentHashMap<Class<?>, Field[]>();
      
  private static Field[] getValueFields(Class<?> type) {
    Field[] fields = valueFieldMap.get(type);
    if (fields == null) {
      fields = introspectValueFields(type);
      valueFieldMap.put(type, fields);
    }
    return fields;
  }
  
  private static List<Object> toValueList(Object obj, Field[] fields) {
    List<Object> list = new ArrayList<Object>();
    for (Field field : fields) {
      try {
        list.add(field.get(obj));
      } catch (IllegalAccessException e) {
        throw new RuntimeException(e);
      }
    }
    return list;
  }
  
  private static Field[] introspectValueFields(Class<?> type) {
    if (type == ValueObject.class) {
      return NO_FIELD;
    }
    List<Field> fieldList = new ArrayList<Field>();
    fieldList.addAll(Arrays.asList(introspectValueFields(type.getSuperclass())));
    List<Field> myFields = tail(fieldList);
    for (Field field : type.getDeclaredFields()) {
      if (!Modifier.isStatic(field.getModifiers()) && Modifier.isFinal(field.getModifiers())) {
        myFields.add(field);
      }
    }
    Collections.sort(myFields, NAME_ORDER);
    Field[] fields = fieldList.toArray(new Field[fieldList.size()]);
    AccessibleObject.setAccessible(fields, true);
    return fields;
  }

  private static <T> List<T> tail(List<T> list) {
    int size = list.size();
    return list.subList(size, size);
  }
  
  private static final Field[] NO_FIELD = new Field[0];
  
  
  
  
  
  
  
  
  
 /* 
  * Code for Output 
  */
  
  /**
   * Returns the contents of this node for the output transformer
   * @return The contents of the current node in the ParserTree (Defaults to OUTPUT_EMPTY_ELEMENT) 
   */
  protected String toTransformerOutput() {
	return OUTPUT_EMPTY_ELEMENT;
  }
  
  /**
   * Puts quotes around a text literal.
   * Allows for changing the type of quotes to be used with literals
   * @param textLiteralOutput the literal to be surrounded by quotes
   * @return literal surrounded by quotes
   */
  protected String outputQuote(String textLiteralOutput) {
	return OUTPUT_QUOTE + textLiteralOutput + OUTPUT_QUOTE;	  
  }
  
  /**
   * Puts quotes directly around the contents of a ValueObject
   * @param valueObject the ValueObject having the contents to be quoted
   * @return the ValueObject's contents with quotes
   */
  protected String outputQuote(ValueObject valueObject) {
	return outputQuote(valueObject.toString());	  
  }
  
  /**
   * Adds (a) new element(s) to a list in text form 
   * @param list is an existing list in text form
   * @param newListItem is/are (a) new item(s) to be added in text form
   * @return New list with both the original list and the new item(s)
   */
  protected String outputAddToList(String list, String newListItem) {
	if (newListItem == OUTPUT_LIST_EMPTY) {
	  return list;
	}
	if (list == OUTPUT_LIST_EMPTY) {
	  return newListItem;
	}
	return list + OUTPUT_LIST_SEPARATOR + newListItem;		  
  }
  
  /**
   * Transforms a List of ValueObjects into a list in text form
   * @param listToTransform List of ValueObjects to be transformed
   * @return list of contents of listToTransform in text form
   */
  protected String listToTransformerOutput(ArrayList<? extends ValueObject> listToTransform) {
    String Result = OUTPUT_LIST_EMPTY;    
	for (ValueObject valueObject : listToTransform) {
      Result = outputAddToList(Result, valueObject.toTransformerOutput());
	}	  
	return Result.toString();
  }
  
  /**
   * puts list type braces around an unbraced list in text form  
   * @param unbracedList list in text form, without braces
   * @return the unbraced list with the begin and end braces for a list
   */
  protected String outputBracedList(String unbracedList) {
	if ((unbracedList != OUTPUT_LIST_EMPTY) && (unbracedList != "")) {  
	  return OUTPUT_LIST_BEGIN + unbracedList + OUTPUT_LIST_END;
	}
	else
	{
	  return unbracedList;	
	}
  }
  
  /**
   * Adds (a) new element(s) to a block in text form
   * @param block is an existing block in text form 
   * @param newBlockItem is/are (a) new item(s) to be added in text form
   * @return New block with both the original block and the new item(s)
   */
  protected String outputAddToBlock(String block, String newBlockItem) {
	if (newBlockItem == OUTPUT_BLOCK_EMPTY) {
	  return block;
	}
	if (block == OUTPUT_BLOCK_EMPTY) {
	  return newBlockItem;
	}
	return block + OUTPUT_BLOCK_SEPARATOR + newBlockItem;
  }
  
  /**
   * Transforms a List of ValueObjects into a block in text form
   * @param blockToTransform List of ValueObjects to be transformed
   * @return block of contents of listToTransform in text form
   */
  protected String blockToTransformerOutput(ArrayList<? extends ValueObject> blockToTransform) {
	String Result = OUTPUT_BLOCK_EMPTY;    
	for (ValueObject valueObject : blockToTransform) {
	  Result = outputAddToList(Result, valueObject.toTransformerOutput());
	}	  
	return Result.toString();
  }
 
  /**
   * puts block type braces around an unbraced block in text form  
   * @param unbracedBlock block in text form, without braces
   * @return the unbraced list with the begin and end braces for a block
   */
  protected String outputBracedBlock(String unbracedBlock) {
	  return OUTPUT_BLOCK_BEGIN + unbracedBlock + OUTPUT_BLOCK_END;
  } 
  
}
