package com.uva.se.wparse.model;

import java.util.List;



public final class SiteDef extends ValueObject implements Member {
  
  public final String name;
  public final List<MappingDef> paths;
  
  
  
  
  public SiteDef( String name, List<MappingDef> paths){
    
    this.name = name;
    this.paths =null; // paths;
    System.out.println("debug -- inside " + this.getClass().getSimpleName() + " constructor");
  }
  
  @Override public String toString() {
	  return "site " + name + " end";
	  
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
