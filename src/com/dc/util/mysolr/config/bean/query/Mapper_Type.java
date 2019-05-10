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
public class Mapper_Type implements java.io.Serializable {

    /**
     * Field id.
     */
    private java.lang.String id;

    /**
     * Field resultType.
     */
    private java.lang.String resultType;

    /**
     * Field wrapper.
     */
    private java.lang.String wrapper;

    /**
     * Field query.
     */
    private java.lang.String query;

    private java.util.List<java.lang.String> filterQueryList;

    /**
     * Field fields.
     */
    private java.lang.String fields;

    private java.util.List<com.dc.util.mysolr.config.bean.query.Sort> sortList;

    /**
     * Field facets.
     */
    private com.dc.util.mysolr.config.bean.query.Facets facets;

    private java.util.List<com.dc.util.mysolr.config.bean.query.Set> setList;

    public Mapper_Type() {
        super();
        this.filterQueryList = new java.util.ArrayList<java.lang.String>();
        this.sortList = new java.util.ArrayList<com.dc.util.mysolr.config.bean.query.Sort>();
        this.setList = new java.util.ArrayList<com.dc.util.mysolr.config.bean.query.Set>();
    }

    /**
     * 
     * 
     * @param vFilterQuery
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addFilterQuery(final java.lang.String vFilterQuery) throws java.lang.IndexOutOfBoundsException {
        this.filterQueryList.add(vFilterQuery);
    }

    /**
     * 
     * 
     * @param index
     * @param vFilterQuery
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addFilterQuery(final int index,final java.lang.String vFilterQuery) throws java.lang.IndexOutOfBoundsException {
        this.filterQueryList.add(index, vFilterQuery);
    }

    /**
     * 
     * 
     * @param vSet
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSet(final com.dc.util.mysolr.config.bean.query.Set vSet) throws java.lang.IndexOutOfBoundsException {
        this.setList.add(vSet);
    }

    /**
     * 
     * 
     * @param index
     * @param vSet
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSet(final int index,final com.dc.util.mysolr.config.bean.query.Set vSet) throws java.lang.IndexOutOfBoundsException {
        this.setList.add(index, vSet);
    }

    /**
     * 
     * 
     * @param vSort
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSort(final com.dc.util.mysolr.config.bean.query.Sort vSort) throws java.lang.IndexOutOfBoundsException {
        // check for the maximum size
        if (this.sortList.size() >= 999) {
            throw new IndexOutOfBoundsException("addSort has a maximum of 999");
        }

        this.sortList.add(vSort);
    }

    /**
     * 
     * 
     * @param index
     * @param vSort
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSort(final int index,final com.dc.util.mysolr.config.bean.query.Sort vSort) throws java.lang.IndexOutOfBoundsException {
        // check for the maximum size
        if (this.sortList.size() >= 999) {
            throw new IndexOutOfBoundsException("addSort has a maximum of 999");
        }

        this.sortList.add(index, vSort);
    }

    /**
     * Method enumerateFilterQuery.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends java.lang.String> enumerateFilterQuery() {
        return java.util.Collections.enumeration(this.filterQueryList);
    }

    /**
     * Method enumerateSet.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends com.dc.util.mysolr.config.bean.query.Set> enumerateSet() {
        return java.util.Collections.enumeration(this.setList);
    }

    /**
     * Method enumerateSort.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends com.dc.util.mysolr.config.bean.query.Sort> enumerateSort() {
        return java.util.Collections.enumeration(this.sortList);
    }

    /**
     * Returns the value of field 'facets'.
     * 
     * @return the value of field 'Facets'.
     */
    public com.dc.util.mysolr.config.bean.query.Facets getFacets() {
        return this.facets;
    }

    /**
     * Returns the value of field 'fields'.
     * 
     * @return the value of field 'Fields'.
     */
    public java.lang.String getFields() {
        return this.fields;
    }

    /**
     * Method getFilterQuery.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the java.lang.String at the given index
     */
    public java.lang.String getFilterQuery(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.filterQueryList.size()) {
            throw new IndexOutOfBoundsException("getFilterQuery: Index value '" + index + "' not in range [0.." + (this.filterQueryList.size() - 1) + "]");
        }

        return (java.lang.String) filterQueryList.get(index);
    }

    /**
     * Method getFilterQuery.Returns the contents of the collection
     * in an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public java.lang.String[] getFilterQuery() {
        java.lang.String[] array = new java.lang.String[0];
        return this.filterQueryList.toArray(array);
    }

    /**
     * Method getFilterQueryCount.
     * 
     * @return the size of this collection
     */
    public int getFilterQueryCount() {
        return this.filterQueryList.size();
    }

    /**
     * Returns the value of field 'id'.
     * 
     * @return the value of field 'Id'.
     */
    public java.lang.String getId() {
        return this.id;
    }

    /**
     * Returns the value of field 'query'.
     * 
     * @return the value of field 'Query'.
     */
    public java.lang.String getQuery() {
        return this.query;
    }

    /**
     * Returns the value of field 'resultType'.
     * 
     * @return the value of field 'ResultType'.
     */
    public java.lang.String getResultType() {
        return this.resultType;
    }

    /**
     * Method getSet.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.dc.util.mysolr.config.bean.query.Set at the given index
     */
    public com.dc.util.mysolr.config.bean.query.Set getSet(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.setList.size()) {
            throw new IndexOutOfBoundsException("getSet: Index value '" + index + "' not in range [0.." + (this.setList.size() - 1) + "]");
        }

        return setList.get(index);
    }

    /**
     * Method getSet.Returns the contents of the collection in an
     * Array.  <p>Note:  Just in case the collection contents are
     * changing in another thread, we pass a 0-length Array of the
     * correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.dc.util.mysolr.config.bean.query.Set[] getSet() {
        com.dc.util.mysolr.config.bean.query.Set[] array = new com.dc.util.mysolr.config.bean.query.Set[0];
        return this.setList.toArray(array);
    }

    /**
     * Method getSetCount.
     * 
     * @return the size of this collection
     */
    public int getSetCount() {
        return this.setList.size();
    }

    /**
     * Method getSort.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.dc.util.mysolr.config.bean.query.Sort at the given index
     */
    public com.dc.util.mysolr.config.bean.query.Sort getSort(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.sortList.size()) {
            throw new IndexOutOfBoundsException("getSort: Index value '" + index + "' not in range [0.." + (this.sortList.size() - 1) + "]");
        }

        return sortList.get(index);
    }

    /**
     * Method getSort.Returns the contents of the collection in an
     * Array.  <p>Note:  Just in case the collection contents are
     * changing in another thread, we pass a 0-length Array of the
     * correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.dc.util.mysolr.config.bean.query.Sort[] getSort() {
        com.dc.util.mysolr.config.bean.query.Sort[] array = new com.dc.util.mysolr.config.bean.query.Sort[0];
        return this.sortList.toArray(array);
    }

    /**
     * Method getSortCount.
     * 
     * @return the size of this collection
     */
    public int getSortCount() {
        return this.sortList.size();
    }

    /**
     * Returns the value of field 'wrapper'.
     * 
     * @return the value of field 'Wrapper'.
     */
    public java.lang.String getWrapper() {
        return this.wrapper;
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
     * Method iterateFilterQuery.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends java.lang.String> iterateFilterQuery() {
        return this.filterQueryList.iterator();
    }

    /**
     * Method iterateSet.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends com.dc.util.mysolr.config.bean.query.Set> iterateSet() {
        return this.setList.iterator();
    }

    /**
     * Method iterateSort.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends com.dc.util.mysolr.config.bean.query.Sort> iterateSort() {
        return this.sortList.iterator();
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
    public void removeAllFilterQuery() {
        this.filterQueryList.clear();
    }

    /**
     */
    public void removeAllSet() {
        this.setList.clear();
    }

    /**
     */
    public void removeAllSort() {
        this.sortList.clear();
    }

    /**
     * Method removeFilterQuery.
     * 
     * @param vFilterQuery
     * @return true if the object was removed from the collection.
     */
    public boolean removeFilterQuery(final java.lang.String vFilterQuery) {
        boolean removed = filterQueryList.remove(vFilterQuery);
        return removed;
    }

    /**
     * Method removeFilterQueryAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public java.lang.String removeFilterQueryAt(final int index) {
        java.lang.Object obj = this.filterQueryList.remove(index);
        return (java.lang.String) obj;
    }

    /**
     * Method removeSet.
     * 
     * @param vSet
     * @return true if the object was removed from the collection.
     */
    public boolean removeSet(final com.dc.util.mysolr.config.bean.query.Set vSet) {
        boolean removed = setList.remove(vSet);
        return removed;
    }

    /**
     * Method removeSetAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.dc.util.mysolr.config.bean.query.Set removeSetAt(final int index) {
        java.lang.Object obj = this.setList.remove(index);
        return (com.dc.util.mysolr.config.bean.query.Set) obj;
    }

    /**
     * Method removeSort.
     * 
     * @param vSort
     * @return true if the object was removed from the collection.
     */
    public boolean removeSort(final com.dc.util.mysolr.config.bean.query.Sort vSort) {
        boolean removed = sortList.remove(vSort);
        return removed;
    }

    /**
     * Method removeSortAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.dc.util.mysolr.config.bean.query.Sort removeSortAt(final int index) {
        java.lang.Object obj = this.sortList.remove(index);
        return (com.dc.util.mysolr.config.bean.query.Sort) obj;
    }

    /**
     * Sets the value of field 'facets'.
     * 
     * @param facets the value of field 'facets'.
     */
    public void setFacets(final com.dc.util.mysolr.config.bean.query.Facets facets) {
        this.facets = facets;
    }

    /**
     * Sets the value of field 'fields'.
     * 
     * @param fields the value of field 'fields'.
     */
    public void setFields(final java.lang.String fields) {
        this.fields = fields;
    }

    /**
     * 
     * 
     * @param index
     * @param vFilterQuery
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setFilterQuery(final int index,final java.lang.String vFilterQuery) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.filterQueryList.size()) {
            throw new IndexOutOfBoundsException("setFilterQuery: Index value '" + index + "' not in range [0.." + (this.filterQueryList.size() - 1) + "]");
        }

        this.filterQueryList.set(index, vFilterQuery);
    }

    /**
     * 
     * 
     * @param vFilterQueryArray
     */
    public void setFilterQuery(final java.lang.String[] vFilterQueryArray) {
        //-- copy array
        filterQueryList.clear();

        for (int i = 0; i < vFilterQueryArray.length; i++) {
                this.filterQueryList.add(vFilterQueryArray[i]);
        }
    }

    /**
     * Sets the value of field 'id'.
     * 
     * @param id the value of field 'id'.
     */
    public void setId(final java.lang.String id) {
        this.id = id;
    }

    /**
     * Sets the value of field 'query'.
     * 
     * @param query the value of field 'query'.
     */
    public void setQuery(final java.lang.String query) {
        this.query = query;
    }

    /**
     * Sets the value of field 'resultType'.
     * 
     * @param resultType the value of field 'resultType'.
     */
    public void setResultType(final java.lang.String resultType) {
        this.resultType = resultType;
    }

    /**
     * 
     * 
     * @param index
     * @param vSet
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSet(final int index,final com.dc.util.mysolr.config.bean.query.Set vSet) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.setList.size()) {
            throw new IndexOutOfBoundsException("setSet: Index value '" + index + "' not in range [0.." + (this.setList.size() - 1) + "]");
        }

        this.setList.set(index, vSet);
    }

    /**
     * 
     * 
     * @param vSetArray
     */
    public void setSet(final com.dc.util.mysolr.config.bean.query.Set[] vSetArray) {
        //-- copy array
        setList.clear();

        for (int i = 0; i < vSetArray.length; i++) {
                this.setList.add(vSetArray[i]);
        }
    }

    /**
     * 
     * 
     * @param index
     * @param vSort
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSort(final int index,final com.dc.util.mysolr.config.bean.query.Sort vSort) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.sortList.size()) {
            throw new IndexOutOfBoundsException("setSort: Index value '" + index + "' not in range [0.." + (this.sortList.size() - 1) + "]");
        }

        this.sortList.set(index, vSort);
    }

    /**
     * 
     * 
     * @param vSortArray
     */
    public void setSort(final com.dc.util.mysolr.config.bean.query.Sort[] vSortArray) {
        //-- copy array
        sortList.clear();

        for (int i = 0; i < vSortArray.length; i++) {
                this.sortList.add(vSortArray[i]);
        }
    }

    /**
     * Sets the value of field 'wrapper'.
     * 
     * @param wrapper the value of field 'wrapper'.
     */
    public void setWrapper(final java.lang.String wrapper) {
        this.wrapper = wrapper;
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
     * com.dc.util.mysolr.config.bean.query.Mapper_Type
     */
    public static com.dc.util.mysolr.config.bean.query.Mapper_Type unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.dc.util.mysolr.config.bean.query.Mapper_Type) org.exolab.castor.xml.Unmarshaller.unmarshal(com.dc.util.mysolr.config.bean.query.Mapper_Type.class, reader);
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
