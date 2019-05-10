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
public class Mappers_Type implements java.io.Serializable {

    private java.util.List<com.dc.util.mysolr.config.bean.query.Mapper> mapperList;

    public Mappers_Type() {
        super();
        this.mapperList = new java.util.ArrayList<com.dc.util.mysolr.config.bean.query.Mapper>();
    }

    /**
     * 
     * 
     * @param vMapper
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addMapper(final com.dc.util.mysolr.config.bean.query.Mapper vMapper) throws java.lang.IndexOutOfBoundsException {
        // check for the maximum size
        if (this.mapperList.size() >= 999) {
            throw new IndexOutOfBoundsException("addMapper has a maximum of 999");
        }

        this.mapperList.add(vMapper);
    }

    /**
     * 
     * 
     * @param index
     * @param vMapper
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addMapper(final int index,final com.dc.util.mysolr.config.bean.query.Mapper vMapper) throws java.lang.IndexOutOfBoundsException {
        // check for the maximum size
        if (this.mapperList.size() >= 999) {
            throw new IndexOutOfBoundsException("addMapper has a maximum of 999");
        }

        this.mapperList.add(index, vMapper);
    }

    /**
     * Method enumerateMapper.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends com.dc.util.mysolr.config.bean.query.Mapper> enumerateMapper() {
        return java.util.Collections.enumeration(this.mapperList);
    }

    /**
     * Method getMapper.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.dc.util.mysolr.config.bean.query.Mapper at the given inde
     */
    public com.dc.util.mysolr.config.bean.query.Mapper getMapper(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.mapperList.size()) {
            throw new IndexOutOfBoundsException("getMapper: Index value '" + index + "' not in range [0.." + (this.mapperList.size() - 1) + "]");
        }

        return mapperList.get(index);
    }

    /**
     * Method getMapper.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.dc.util.mysolr.config.bean.query.Mapper[] getMapper() {
        com.dc.util.mysolr.config.bean.query.Mapper[] array = new com.dc.util.mysolr.config.bean.query.Mapper[0];
        return this.mapperList.toArray(array);
    }

    /**
     * Method getMapperCount.
     * 
     * @return the size of this collection
     */
    public int getMapperCount() {
        return this.mapperList.size();
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
     * Method iterateMapper.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends com.dc.util.mysolr.config.bean.query.Mapper> iterateMapper() {
        return this.mapperList.iterator();
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
    public void removeAllMapper() {
        this.mapperList.clear();
    }

    /**
     * Method removeMapper.
     * 
     * @param vMapper
     * @return true if the object was removed from the collection.
     */
    public boolean removeMapper(final com.dc.util.mysolr.config.bean.query.Mapper vMapper) {
        boolean removed = mapperList.remove(vMapper);
        return removed;
    }

    /**
     * Method removeMapperAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.dc.util.mysolr.config.bean.query.Mapper removeMapperAt(final int index) {
        java.lang.Object obj = this.mapperList.remove(index);
        return (com.dc.util.mysolr.config.bean.query.Mapper) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vMapper
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setMapper(final int index,final com.dc.util.mysolr.config.bean.query.Mapper vMapper) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.mapperList.size()) {
            throw new IndexOutOfBoundsException("setMapper: Index value '" + index + "' not in range [0.." + (this.mapperList.size() - 1) + "]");
        }

        this.mapperList.set(index, vMapper);
    }

    /**
     * 
     * 
     * @param vMapperArray
     */
    public void setMapper(final com.dc.util.mysolr.config.bean.query.Mapper[] vMapperArray) {
        //-- copy array
        mapperList.clear();

        for (int i = 0; i < vMapperArray.length; i++) {
                this.mapperList.add(vMapperArray[i]);
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
     * com.dc.util.mysolr.config.bean.query.Mappers_Type
     */
    public static com.dc.util.mysolr.config.bean.query.Mappers_Type unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.dc.util.mysolr.config.bean.query.Mappers_Type) org.exolab.castor.xml.Unmarshaller.unmarshal(com.dc.util.mysolr.config.bean.query.Mappers_Type.class, reader);
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
