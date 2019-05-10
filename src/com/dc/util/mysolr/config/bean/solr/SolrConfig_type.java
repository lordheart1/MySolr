/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.dc.util.mysolr.config.bean.solr;

/**
 * 
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class SolrConfig_type implements java.io.Serializable {

    private java.util.List<com.dc.util.mysolr.config.bean.solr.File> fileList;

    public SolrConfig_type() {
        super();
        this.fileList = new java.util.ArrayList<com.dc.util.mysolr.config.bean.solr.File>();
    }

    /**
     * 
     * 
     * @param vFile
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addFile(final com.dc.util.mysolr.config.bean.solr.File vFile) throws java.lang.IndexOutOfBoundsException {
        // check for the maximum size
        if (this.fileList.size() >= 999) {
            throw new IndexOutOfBoundsException("addFile has a maximum of 999");
        }

        this.fileList.add(vFile);
    }

    /**
     * 
     * 
     * @param index
     * @param vFile
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addFile(final int index,final com.dc.util.mysolr.config.bean.solr.File vFile) throws java.lang.IndexOutOfBoundsException {
        // check for the maximum size
        if (this.fileList.size() >= 999) {
            throw new IndexOutOfBoundsException("addFile has a maximum of 999");
        }

        this.fileList.add(index, vFile);
    }

    /**
     * Method enumerateFile.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends com.dc.util.mysolr.config.bean.solr.File> enumerateFile() {
        return java.util.Collections.enumeration(this.fileList);
    }

    /**
     * Method getFile.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.dc.util.mysolr.config.bean.solr.File at the given index
     */
    public com.dc.util.mysolr.config.bean.solr.File getFile(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.fileList.size()) {
            throw new IndexOutOfBoundsException("getFile: Index value '" + index + "' not in range [0.." + (this.fileList.size() - 1) + "]");
        }

        return fileList.get(index);
    }

    /**
     * Method getFile.Returns the contents of the collection in an
     * Array.  <p>Note:  Just in case the collection contents are
     * changing in another thread, we pass a 0-length Array of the
     * correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.dc.util.mysolr.config.bean.solr.File[] getFile() {
        com.dc.util.mysolr.config.bean.solr.File[] array = new com.dc.util.mysolr.config.bean.solr.File[0];
        return this.fileList.toArray(array);
    }

    /**
     * Method getFileCount.
     * 
     * @return the size of this collection
     */
    public int getFileCount() {
        return this.fileList.size();
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
     * Method iterateFile.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends com.dc.util.mysolr.config.bean.solr.File> iterateFile() {
        return this.fileList.iterator();
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
    public void removeAllFile() {
        this.fileList.clear();
    }

    /**
     * Method removeFile.
     * 
     * @param vFile
     * @return true if the object was removed from the collection.
     */
    public boolean removeFile(final com.dc.util.mysolr.config.bean.solr.File vFile) {
        boolean removed = fileList.remove(vFile);
        return removed;
    }

    /**
     * Method removeFileAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.dc.util.mysolr.config.bean.solr.File removeFileAt(final int index) {
        java.lang.Object obj = this.fileList.remove(index);
        return (com.dc.util.mysolr.config.bean.solr.File) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vFile
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setFile(final int index,final com.dc.util.mysolr.config.bean.solr.File vFile) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.fileList.size()) {
            throw new IndexOutOfBoundsException("setFile: Index value '" + index + "' not in range [0.." + (this.fileList.size() - 1) + "]");
        }

        this.fileList.set(index, vFile);
    }

    /**
     * 
     * 
     * @param vFileArray
     */
    public void setFile(final com.dc.util.mysolr.config.bean.solr.File[] vFileArray) {
        //-- copy array
        fileList.clear();

        for (int i = 0; i < vFileArray.length; i++) {
                this.fileList.add(vFileArray[i]);
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
     * com.dc.util.mysolr.config.bean.solr.SolrConfig_type
     */
    public static com.dc.util.mysolr.config.bean.solr.SolrConfig_type unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.dc.util.mysolr.config.bean.solr.SolrConfig_type) org.exolab.castor.xml.Unmarshaller.unmarshal(com.dc.util.mysolr.config.bean.solr.SolrConfig_type.class, reader);
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
