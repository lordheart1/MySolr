/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.dc.util.mysolr.config.bean.query.types;

/**
 * Enumeration TypeType.
 * 
 * @version $Revision$ $Date$
 */
public enum TypeType {


      //------------------/
     //- Enum Constants -/
    //------------------/

    /**
     * Constant DESC
     */
    DESC("desc"),
    /**
     * Constant ASC
     */
    ASC("asc");
    /**
     * Field value.
     */
    private final java.lang.String value;

    /**
     * Field enumConstants.
     */
    private static final java.util.Map<java.lang.String, TypeType> enumConstants = new java.util.HashMap<java.lang.String, TypeType>();


    static {
        for (TypeType c: TypeType.values()) {
            TypeType.enumConstants.put(c.value, c);
        }

    }

    private TypeType(final java.lang.String value) {
        this.value = value;
    }

    /**
     * Method fromValue.
     * 
     * @param value
     * @return the constant for this value
     */
    public static com.dc.util.mysolr.config.bean.query.types.TypeType fromValue(final java.lang.String value) {
        TypeType c = TypeType.enumConstants.get(value);
        if (c != null) {
            return c;
        }
        throw new IllegalArgumentException(value);
    }

    /**
     * 
     * 
     * @param value
     */
    public void setValue(final java.lang.String value) {
    }

    /**
     * Method toString.
     * 
     * @return the value of this constant
     */
    public java.lang.String toString() {
        return this.value;
    }

    /**
     * Method value.
     * 
     * @return the value of this constant
     */
    public java.lang.String value() {
        return this.value;
    }

}
