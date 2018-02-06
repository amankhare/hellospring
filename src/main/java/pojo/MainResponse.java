
package pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class MainResponse implements Serializable
{

    @SerializedName("dataSet")
    @Expose
    private List<DataSet2> dataSet = new ArrayList<DataSet2>();
    protected final static Object NOT_FOUND_VALUE = new Object();
    private final static long serialVersionUID = 4469360734060061405L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public MainResponse() {
    }

    /**
     * 
     * @param dataSet
     */
    public MainResponse(List<DataSet2> dataSet) {
        this.dataSet = dataSet;
    }

    /**
     * 
     * @return
     *     The dataSet
     */
    public List<DataSet2> getDataSet() {
        return dataSet;
    }

    /**
     * 
     * @param dataSet
     *     The dataSet
     */
    public void setDataSet(List<DataSet2> dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    protected boolean declaredProperty(String name, Object value) {
        if ("dataSet".equals(name)) {
            if (value instanceof List) {
                setDataSet(((List<DataSet2> ) value));
            } else {
                throw new IllegalArgumentException(("property \"dataSet\" is of type \"java.util.List<com.example.pojo.DataSet>\", but got "+ value.getClass().toString()));
            }
            return true;
        } else {
            return false;
        }
    }

    protected Object declaredPropertyOrNotFound(String name, Object notFoundValue) {
        if ("dataSet".equals(name)) {
            return getDataSet();
        } else {
            return notFoundValue;
        }
    }

    @SuppressWarnings({
        "unchecked"
    })
    public<T >T get(String name) {
        Object value = declaredPropertyOrNotFound(name, MainResponse.NOT_FOUND_VALUE);
        if (MainResponse.NOT_FOUND_VALUE!= value) {
            return ((T) value);
        } else {
            throw new IllegalArgumentException((("property \""+ name)+"\" is not defined"));
        }
    }

    public void set(String name, Object value) {
        if (!declaredProperty(name, value)) {
            throw new IllegalArgumentException((("property \""+ name)+"\" is not defined"));
        }
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(dataSet).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof MainResponse) == false) {
            return false;
        }
        MainResponse rhs = ((MainResponse) other);
        return new EqualsBuilder().append(dataSet, rhs.dataSet).isEquals();
    }

}
