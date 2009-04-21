package com.uva.se.app.model;

import java.util.List;


public final class MethodDef extends ValueObject implements Member {
  
  public final String name;
  //public final List<String> parameters;
  
  
  
  
  public MethodDef( String name){ //, List<String> parameters) {
    
    this.name = name;
    //this.parameters = parameters;
    
  }

//  @Override public String toString() {
//    StringBuilder builder = new StringBuilder();
//    for (Modifier modifier : modifiers) {
//      builder.append(modifier).append(' ');
//    }
//    if (typeParameters != null) {
//      builder.append('<');
//      Strings.join(builder, ", ", typeParameters);
//      builder.append("> ");
//    }
//    builder.append(returnType).append(' ').append(name).append('(');
//    Strings.join(builder, ", ", parameters);
//    builder.append(')');
//    if (exceptions != null) {
//      builder.append(" throws ");
//      Strings.join(builder, ", ", exceptions);
//    }
//    if (defaultValue != null) {
//      builder.append(" default ").append(defaultValue);
//    }
//    if (body == null) {
//      builder.append(';');
//    } else {
//      builder.append(' ').append(body);
//    }
//    return builder.toString();
//  }
}
