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
package org.mybatis.generator.internal;

import static org.mybatis.generator.internal.util.StringUtility.isTrue;

import java.util.Properties;
import java.util.Set;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.InnerEnum;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.PropertyRegistry;
import org.mybatis.generator.internal.util.StringUtility;

/**
 * @author xs6677
 */
public class ModelFieldCommentGenerator implements CommentGenerator {
	
	private Properties properties;

    private boolean suppressAllComments;

    public ModelFieldCommentGenerator() {
    	super();
        properties = new Properties();
        suppressAllComments = false;
    }

	@Override
	public void addConfigurationProperties(Properties properties) {
		this.properties.putAll(properties);

        suppressAllComments = isTrue(properties
                .getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_ALL_COMMENTS));
	}

	@Override
	public void addFieldComment(Field field, IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {
		if (suppressAllComments) {
            return;
        }

        field.addJavaDocLine("/**"); //$NON-NLS-1$

        String remarks = introspectedColumn.getRemarks();
        if (StringUtility.stringHasValue(remarks)) {
            String[] remarkLines = remarks.split(System.getProperty("line.separator"));  //$NON-NLS-1$
            for (String remarkLine : remarkLines) {
                field.addJavaDocLine(" *   " + remarkLine);  //$NON-NLS-1$
            }
        }

        field.addJavaDocLine(" */"); //$NON-NLS-1$
	}

	@Override
	public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
		// add no document level comments
		
	}

	@Override
	public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		// add no document level comments
		
	}

	@Override
	public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {
		// add no document level comments
		
	}

	@Override
	public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {
		// add no document level comments
		
	}

	@Override
	public void addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable) {
		// add no document level comments
		
	}

	@Override
	public void addGetterComment(Method method, IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {
		// add no document level comments
		
	}

	@Override
	public void addSetterComment(Method method, IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {
		// add no document level comments
		
	}

	@Override
	public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {
		// add no document level comments
		
	}

	@Override
	public void addJavaFileComment(CompilationUnit compilationUnit) {
		// add no document level comments
		
	}

	@Override
	public void addComment(XmlElement xmlElement) {
		// add no document level comments
		
	}

	@Override
	public void addRootComment(XmlElement rootElement) {
		// add no document level comments
		
	}

	@Override
	public void addGeneralMethodAnnotation(Method method, IntrospectedTable introspectedTable,
			Set<FullyQualifiedJavaType> imports) {
		// add no document level comments
		
	}

	@Override
	public void addGeneralMethodAnnotation(Method method, IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn, Set<FullyQualifiedJavaType> imports) {
		// add no document level comments
		
	}

	@Override
	public void addFieldAnnotation(Field field, IntrospectedTable introspectedTable,
			Set<FullyQualifiedJavaType> imports) {
		// add no document level comments
		
	}

	@Override
	public void addFieldAnnotation(Field field, IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn, Set<FullyQualifiedJavaType> imports) {
		// add no document level comments
		
	}

	@Override
	public void addClassAnnotation(InnerClass innerClass, IntrospectedTable introspectedTable,
			Set<FullyQualifiedJavaType> imports) {
		// add no document level comments

	}

}
