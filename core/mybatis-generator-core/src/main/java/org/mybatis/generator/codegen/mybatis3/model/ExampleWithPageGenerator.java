/**
 *    Copyright 2006-2018 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.mybatis.generator.codegen.mybatis3.model;

import java.util.List;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;

/**
 * @author xs6677
 */
public class ExampleWithPageGenerator extends ExampleGenerator {

    public ExampleWithPageGenerator() {
        super();
    }

    @Override
    public List<CompilationUnit> getCompilationUnits() {
    	List<CompilationUnit> answer = super.getCompilationUnits();
    	CommentGenerator commentGenerator = context.getCommentGenerator();
    	
    	TopLevelClass topLevelClass;
		if (!answer.isEmpty()) {
			topLevelClass = (TopLevelClass) answer.get(0);
		} else {
			return answer;
		}
    	
    	// add field, getter, setter for page
        Field field = new Field();
        field.setVisibility(JavaVisibility.PROTECTED);
        field.setType(FullyQualifiedJavaType.getBooleanPrimitiveInstance());
        field.setName("page"); //$NON-NLS-1$
        commentGenerator.addFieldComment(field, introspectedTable);
        topLevelClass.addField(field);

        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setName("setPage"); //$NON-NLS-1$
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getBooleanPrimitiveInstance(), "page")); //$NON-NLS-1$
        method.addBodyLine("this.page = page;"); //$NON-NLS-1$
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);

        method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(FullyQualifiedJavaType.getBooleanPrimitiveInstance());
        method.setName("isPage"); //$NON-NLS-1$
        method.addBodyLine("return page;"); //$NON-NLS-1$
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);
        
        // add field, getter, setter for offset
        field = new Field();
        field.setVisibility(JavaVisibility.PROTECTED);
        field.setType(FullyQualifiedJavaType.getIntInstance());
        field.setName("offset"); //$NON-NLS-1$
        commentGenerator.addFieldComment(field, introspectedTable);
        topLevelClass.addField(field);

        method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setName("setOffset"); //$NON-NLS-1$
        method.addParameter(new Parameter(FullyQualifiedJavaType.getIntInstance(), "offset")); //$NON-NLS-1$
        method.addBodyLine("this.offset = offset;"); //$NON-NLS-1$
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);

        method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(FullyQualifiedJavaType.getIntInstance());
        method.setName("isOffset"); //$NON-NLS-1$
        method.addBodyLine("return offset;"); //$NON-NLS-1$
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);
        
        // add field, getter, setter for count
        field = new Field();
        field.setVisibility(JavaVisibility.PROTECTED);
        field.setType(FullyQualifiedJavaType.getIntInstance());
        field.setName("count"); //$NON-NLS-1$
        commentGenerator.addFieldComment(field, introspectedTable);
        topLevelClass.addField(field);

        method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setName("setCount"); //$NON-NLS-1$
        method.addParameter(new Parameter(FullyQualifiedJavaType.getIntInstance(), "count")); //$NON-NLS-1$
        method.addBodyLine("this.count = count;"); //$NON-NLS-1$
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);

        method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(FullyQualifiedJavaType.getIntInstance());
        method.setName("isCount"); //$NON-NLS-1$
        method.addBodyLine("return count;"); //$NON-NLS-1$
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);
        
        // add method for startPage
        method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setName("startPage"); //$NON-NLS-1$
        method.addParameter(new Parameter(FullyQualifiedJavaType.getIntInstance(), "offset")); //$NON-NLS-1$
        method.addParameter(new Parameter(FullyQualifiedJavaType.getIntInstance(), "count")); //$NON-NLS-1$
        method.addBodyLine("page = true;"); //$NON-NLS-1$
        method.addBodyLine("this.offset = offset;"); //$NON-NLS-1$
        method.addBodyLine("this.count = count;"); //$NON-NLS-1$
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);
        
        // add method for clearPage
        method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setName("clearPage"); //$NON-NLS-1$
        method.addBodyLine("page = false;"); //$NON-NLS-1$
        method.addBodyLine("offset = 0;"); //$NON-NLS-1$
        method.addBodyLine("count = 0;"); //$NON-NLS-1$
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);
        
        // edit method for clear
        for (Method _method : topLevelClass.getMethods()) {
        	if ("clear".equals(_method.getName())) {
        		_method.addBodyLine("clearPage();");
        		break;
        	}
		}
    	return answer;
    }
}
