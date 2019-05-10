/*     */ package com.dc.util.mysolr.config.bean.query.descriptors;
/*     */ 
/*     */ import com.dc.util.mysolr.config.bean.query.FacetField;
/*     */ import org.exolab.castor.mapping.AccessMode;
/*     */ import org.exolab.castor.mapping.FieldDescriptor;
/*     */ import org.exolab.castor.xml.TypeValidator;
/*     */ import org.exolab.castor.xml.XMLFieldDescriptor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FacetFieldDescriptor
/*     */   extends FacetField_TypeDescriptor
/*     */ {
/*     */   private boolean _elementDefinition;
/*     */   private String _nsPrefix;
/*     */   private String _nsURI;
/*     */   private String _xmlName;
/*     */   private XMLFieldDescriptor _identity;
/*     */   
/*     */   public FacetFieldDescriptor()
/*     */   {
/*  50 */     setExtendsWithoutFlatten(new FacetField_TypeDescriptor());
/*  51 */     this._xmlName = "facetField";
/*  52 */     this._elementDefinition = true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public AccessMode getAccessMode()
/*     */   {
/*  62 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public FieldDescriptor getIdentity()
/*     */   {
/*  73 */     if (this._identity == null) {
/*  74 */       return super.getIdentity();
/*     */     }
/*  76 */     return this._identity;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Class getJavaClass()
/*     */   {
/*  86 */     return FacetField.class;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getNameSpacePrefix()
/*     */   {
/*  96 */     return this._nsPrefix;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getNameSpaceURI()
/*     */   {
/* 107 */     return this._nsURI;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public TypeValidator getValidator()
/*     */   {
/* 118 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getXMLName()
/*     */   {
/* 128 */     return this._xmlName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isElementDefinition()
/*     */   {
/* 139 */     return this._elementDefinition;
/*     */   }
/*     */ }


