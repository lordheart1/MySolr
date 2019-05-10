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
public class Set_Type implements java.io.Serializable {

    /**
     * Field key.
     */
    private java.lang.String key;

    /**
     * Field value.
     */
    private java.lang.String value;

    /**
     * Field isTrue.
     */
    private boolean isTrue;

    /**
     * Keeps track of whether primitive field isTrue has been set
     * already.
     */
    private boolean _hasisTrue;

    public Set_Type() {
        super();
    }

    /**
     */
    public void deleteIsTrue() {
        this._hasisTrue= false;
    }

    /**
     * Returns the value of field 'isTrue'.
     * 
     * @return the value of field 'IsTrue'.
     */
    public boolean getIsTrue() {
        return this.isTrue;
    }

    /**
     * Returns the value of field 'key'.
     * 
     * @return the value of field 'Key'.
     */
    public java.lang.String getKey() {
        return this.key;
    }

    /**
     * Returns the value of field 'value'.
     * 
     * @return the value of field 'Value'.
     */
    public java.lang.String getValue() {
        return this.value;
    }

    /**
     * Method hasIsTrue.
     * 
     * @return true if at least one IsTrue has been added
     */
    public boolean hasIsTrue() {
        return this._hasisTrue;
    }

    /**
     * Returns the value of field 'isTrue'.
     * 
     * @return the value of field 'IsTrue'.
     */
    public boolean isIsTrue() {
        return this.isTrue;
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
     * Sets the value of field 'isTrue'.
     * 
     * @param isTrue the value of field 'isTrue'.
     */
    public void setIsTrue(final boolean isTrue) {
        this.isTrue = isTrue;
        this._hasisTrue = true;
    }

    /**
     * Sets the value of field 'key'.
     * 
     * @param key the value of field 'key'.
     */
    public void setKey(final java.lang.String key) {
        this.key = key;
    }

    /**
     * Sets the value of field 'value'.
     * 
     * @param value the value of field 'value'.
     */
    public void setValue(final java.lang.String value) {
        this.value = value;
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
     * com.dc.util.mysolr.config.bean.query.Set_Type
     */
    public static com.dc.util.mysolr.config.bean.query.Set_Type unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.dc.util.mysolr.config.bean.query.Set_Type) org.exolab.castor.xml.Unmarshaller.unmarshal(com.dc.util.mysolr.config.bean.query.Set_Type.class, reader);
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
