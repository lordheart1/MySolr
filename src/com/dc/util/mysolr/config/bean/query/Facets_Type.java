/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.dc.util.mysolr.config.bean.query;

/**
 * 
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class Facets_Type implements java.io.Serializable {

    /**
     * Field facetLimit.
     */
    private int facetLimit = 100;

    /**
     * Keeps track of whether primitive field facetLimit has been
     * set already.
     */
    private boolean _hasfacetLimit;

    /**
     * Field facetMinCount.
     */
    private int facetMinCount = 1;

    /**
     * Keeps track of whether primitive field facetMinCount has
     * been set already.
     */
    private boolean _hasfacetMinCount;

    /**
     * Field fusion.
     */
    private java.lang.String fusion = "false";

    /**
     * Field facet.
     */
    private java.lang.String facet = "false";

    private java.util.List<com.dc.util.mysolr.config.bean.query.FacetField> facetFieldList;

    public Facets_Type() {
        super();
        setFusion("false");
        setFacet("false");
        this.facetFieldList = new java.util.ArrayList<com.dc.util.mysolr.config.bean.query.FacetField>();
    }

    /**
     * 
     * 
     * @param vFacetField
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addFacetField(final com.dc.util.mysolr.config.bean.query.FacetField vFacetField) throws java.lang.IndexOutOfBoundsException {
        // check for the maximum size
        if (this.facetFieldList.size() >= 999) {
            throw new IndexOutOfBoundsException("addFacetField has a maximum of 999");
        }

        this.facetFieldList.add(vFacetField);
    }

    /**
     * 
     * 
     * @param index
     * @param vFacetField
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addFacetField(final int index,final com.dc.util.mysolr.config.bean.query.FacetField vFacetField) throws java.lang.IndexOutOfBoundsException {
        // check for the maximum size
        if (this.facetFieldList.size() >= 999) {
            throw new IndexOutOfBoundsException("addFacetField has a maximum of 999");
        }

        this.facetFieldList.add(index, vFacetField);
    }

    /**
     */
    public void deleteFacetLimit() {
        this._hasfacetLimit= false;
    }

    /**
     */
    public void deleteFacetMinCount() {
        this._hasfacetMinCount= false;
    }

    /**
     * Method enumerateFacetField.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends com.dc.util.mysolr.config.bean.query.FacetField> enumerateFacetField() {
        return java.util.Collections.enumeration(this.facetFieldList);
    }

    /**
     * Returns the value of field 'facet'.
     * 
     * @return the value of field 'Facet'.
     */
    public java.lang.String getFacet() {
        return this.facet;
    }

    /**
     * Method getFacetField.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.dc.util.mysolr.config.bean.query.FacetField at the given
     * index
     */
    public com.dc.util.mysolr.config.bean.query.FacetField getFacetField(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.facetFieldList.size()) {
            throw new IndexOutOfBoundsException("getFacetField: Index value '" + index + "' not in range [0.." + (this.facetFieldList.size() - 1) + "]");
        }

        return facetFieldList.get(index);
    }

    /**
     * Method getFacetField.Returns the contents of the collection
     * in an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.dc.util.mysolr.config.bean.query.FacetField[] getFacetField() {
        com.dc.util.mysolr.config.bean.query.FacetField[] array = new com.dc.util.mysolr.config.bean.query.FacetField[0];
        return this.facetFieldList.toArray(array);
    }

    /**
     * Method getFacetFieldCount.
     * 
     * @return the size of this collection
     */
    public int getFacetFieldCount() {
        return this.facetFieldList.size();
    }

    /**
     * Returns the value of field 'facetLimit'.
     * 
     * @return the value of field 'FacetLimit'.
     */
    public int getFacetLimit() {
        return this.facetLimit;
    }

    /**
     * Returns the value of field 'facetMinCount'.
     * 
     * @return the value of field 'FacetMinCount'.
     */
    public int getFacetMinCount() {
        return this.facetMinCount;
    }

    /**
     * Returns the value of field 'fusion'.
     * 
     * @return the value of field 'Fusion'.
     */
    public java.lang.String getFusion() {
        return this.fusion;
    }

    /**
     * Method hasFacetLimit.
     * 
     * @return true if at least one FacetLimit has been added
     */
    public boolean hasFacetLimit() {
        return this._hasfacetLimit;
    }

    /**
     * Method hasFacetMinCount.
     * 
     * @return true if at least one FacetMinCount has been added
     */
    public boolean hasFacetMinCount() {
        return this._hasfacetMinCount;
    }

    /**
     * Method isValid.
     * 
     * @return true if this object is valid according to the schema
     */
    public boolean isValid() {
        try {
            validate();
        } catch (org.exolab.castor.xml.ValidationException vex) {
            return false;
        }
        return true;
    }

    /**
     * Method iterateFacetField.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends com.dc.util.mysolr.config.bean.query.FacetField> iterateFacetField() {
        return this.facetFieldList.iterator();
    }

    /**
     * 
     * 
     * @param out
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void marshal(final java.io.Writer out) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Marshaller.marshal(this, out);
    }

    /**
     * 
     * 
     * @param handler
     * @throws java.io.IOException if an IOException occurs during
     * marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     */
    public void marshal(final org.xml.sax.ContentHandler handler) throws java.io.IOException, org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Marshaller.marshal(this, handler);
    }

    /**
     */
    public void removeAllFacetField() {
        this.facetFieldList.clear();
    }

    /**
     * Method removeFacetField.
     * 
     * @param vFacetField
     * @return true if the object was removed from the collection.
     */
    public boolean removeFacetField(final com.dc.util.mysolr.config.bean.query.FacetField vFacetField) {
        boolean removed = facetFieldList.remove(vFacetField);
        return removed;
    }

    /**
     * Method removeFacetFieldAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.dc.util.mysolr.config.bean.query.FacetField removeFacetFieldAt(final int index) {
        java.lang.Object obj = this.facetFieldList.remove(index);
        return (com.dc.util.mysolr.config.bean.query.FacetField) obj;
    }

    /**
     * Sets the value of field 'facet'.
     * 
     * @param facet the value of field 'facet'.
     */
    public void setFacet(final java.lang.String facet) {
        this.facet = facet;
    }

    /**
     * 
     * 
     * @param index
     * @param vFacetField
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setFacetField(final int index,final com.dc.util.mysolr.config.bean.query.FacetField vFacetField) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.facetFieldList.size()) {
            throw new IndexOutOfBoundsException("setFacetField: Index value '" + index + "' not in range [0.." + (this.facetFieldList.size() - 1) + "]");
        }

        this.facetFieldList.set(index, vFacetField);
    }

    /**
     * 
     * 
     * @param vFacetFieldArray
     */
    public void setFacetField(final com.dc.util.mysolr.config.bean.query.FacetField[] vFacetFieldArray) {
        //-- copy array
        facetFieldList.clear();

        for (int i = 0; i < vFacetFieldArray.length; i++) {
                this.facetFieldList.add(vFacetFieldArray[i]);
        }
    }

    /**
     * Sets the value of field 'facetLimit'.
     * 
     * @param facetLimit the value of field 'facetLimit'.
     */
    public void setFacetLimit(final int facetLimit) {
        this.facetLimit = facetLimit;
        this._hasfacetLimit = true;
    }

    /**
     * Sets the value of field 'facetMinCount'.
     * 
     * @param facetMinCount the value of field 'facetMinCount'.
     */
    public void setFacetMinCount(final int facetMinCount) {
        this.facetMinCount = facetMinCount;
        this._hasfacetMinCount = true;
    }

    /**
     * Sets the value of field 'fusion'.
     * 
     * @param fusion the value of field 'fusion'.
     */
    public void setFusion(final java.lang.String fusion) {
        this.fusion = fusion;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled
     * com.dc.util.mysolr.config.bean.query.Facets_Type
     */
    public static com.dc.util.mysolr.config.bean.query.Facets_Type unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.dc.util.mysolr.config.bean.query.Facets_Type) org.exolab.castor.xml.Unmarshaller.unmarshal(com.dc.util.mysolr.config.bean.query.Facets_Type.class, reader);
    }

    /**
     * 
     * 
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void validate() throws org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    }

}
