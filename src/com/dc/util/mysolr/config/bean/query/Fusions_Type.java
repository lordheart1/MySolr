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
public class Fusions_Type implements java.io.Serializable {

    private java.util.List<java.lang.String> fusionFieldList;

    public Fusions_Type() {
        super();
        this.fusionFieldList = new java.util.ArrayList<java.lang.String>();
    }

    /**
     * 
     * 
     * @param vFusionField
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addFusionField(final java.lang.String vFusionField) throws java.lang.IndexOutOfBoundsException {
        // check for the maximum size
        if (this.fusionFieldList.size() >= 999) {
            throw new IndexOutOfBoundsException("addFusionField has a maximum of 999");
        }

        this.fusionFieldList.add(vFusionField);
    }

    /**
     * 
     * 
     * @param index
     * @param vFusionField
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addFusionField(final int index,final java.lang.String vFusionField) throws java.lang.IndexOutOfBoundsException {
        // check for the maximum size
        if (this.fusionFieldList.size() >= 999) {
            throw new IndexOutOfBoundsException("addFusionField has a maximum of 999");
        }

        this.fusionFieldList.add(index, vFusionField);
    }

    /**
     * Method enumerateFusionField.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends java.lang.String> enumerateFusionField() {
        return java.util.Collections.enumeration(this.fusionFieldList);
    }

    /**
     * Method getFusionField.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the java.lang.String at the given index
     */
    public java.lang.String getFusionField(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.fusionFieldList.size()) {
            throw new IndexOutOfBoundsException("getFusionField: Index value '" + index + "' not in range [0.." + (this.fusionFieldList.size() - 1) + "]");
        }

        return (java.lang.String) fusionFieldList.get(index);
    }

    /**
     * Method getFusionField.Returns the contents of the collection
     * in an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public java.lang.String[] getFusionField() {
        java.lang.String[] array = new java.lang.String[0];
        return this.fusionFieldList.toArray(array);
    }

    /**
     * Method getFusionFieldCount.
     * 
     * @return the size of this collection
     */
    public int getFusionFieldCount() {
        return this.fusionFieldList.size();
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
     * Method iterateFusionField.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends java.lang.String> iterateFusionField() {
        return this.fusionFieldList.iterator();
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
    public void removeAllFusionField() {
        this.fusionFieldList.clear();
    }

    /**
     * Method removeFusionField.
     * 
     * @param vFusionField
     * @return true if the object was removed from the collection.
     */
    public boolean removeFusionField(final java.lang.String vFusionField) {
        boolean removed = fusionFieldList.remove(vFusionField);
        return removed;
    }

    /**
     * Method removeFusionFieldAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public java.lang.String removeFusionFieldAt(final int index) {
        java.lang.Object obj = this.fusionFieldList.remove(index);
        return (java.lang.String) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vFusionField
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setFusionField(final int index,final java.lang.String vFusionField) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.fusionFieldList.size()) {
            throw new IndexOutOfBoundsException("setFusionField: Index value '" + index + "' not in range [0.." + (this.fusionFieldList.size() - 1) + "]");
        }

        this.fusionFieldList.set(index, vFusionField);
    }

    /**
     * 
     * 
     * @param vFusionFieldArray
     */
    public void setFusionField(final java.lang.String[] vFusionFieldArray) {
        //-- copy array
        fusionFieldList.clear();

        for (int i = 0; i < vFusionFieldArray.length; i++) {
                this.fusionFieldList.add(vFusionFieldArray[i]);
        }
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
     * com.dc.util.mysolr.config.bean.query.Fusions_Type
     */
    public static com.dc.util.mysolr.config.bean.query.Fusions_Type unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.dc.util.mysolr.config.bean.query.Fusions_Type) org.exolab.castor.xml.Unmarshaller.unmarshal(com.dc.util.mysolr.config.bean.query.Fusions_Type.class, reader);
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
