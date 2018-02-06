
package pojo;

import java.io.Serializable;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class DataSet implements Serializable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("value")
    @Expose
    private String value;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("valid")
    @Expose
    private Boolean valid;
    @SerializedName("domain")
    @Expose
    private String domain;
    protected final static Object NOT_FOUND_VALUE = new Object();
    private final static long serialVersionUID = 2193401201758269392L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DataSet() {
    }

    /**
     * 
     * @param valid
     * @param domain
     * @param id
     * @param type
     * @param value
     */
    public DataSet(Integer id, String value, String type, Boolean valid, String domain) {
        this.id = id;
        this.value = value;
        this.type = type;
        this.valid = valid;
        this.domain = domain;
    }

    /**
     * 
     * @return
     *     The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The value
     */
    public String getValue() {
        return value;
    }

    /**
     * 
     * @param value
     *     The value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The valid
     */
    public Boolean getValid() {
        return valid;
    }

    /**
     * 
     * @param valid
     *     The valid
     */
    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    /**
     * 
     * @return
     *     The domain
     */
    public String getDomain() {
        return domain;
    }

    /**
     * 
     * @param domain
     *     The domain
     */
    public void setDomain(String domain) {
        this.domain = domain;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    protected boolean declaredProperty(String name, Object value) {
        if ("id".equals(name)) {
            if (value instanceof Integer) {
                setId(((Integer) value));
            } else {
                throw new IllegalArgumentException(("property \"id\" is of type \"java.lang.Integer\", but got "+ value.getClass().toString()));
            }
            return true;
        } else {
            if ("value".equals(name)) {
                if (value instanceof String) {
                    setValue(((String) value));
                } else {
                    throw new IllegalArgumentException(("property \"value\" is of type \"java.lang.String\", but got "+ value.getClass().toString()));
                }
                return true;
            } else {
                if ("type".equals(name)) {
                    if (value instanceof String) {
                        setType(((String) value));
                    } else {
                        throw new IllegalArgumentException(("property \"type\" is of type \"java.lang.String\", but got "+ value.getClass().toString()));
                    }
                    return true;
                } else {
                    if ("valid".equals(name)) {
                        if (value instanceof Boolean) {
                            setValid(((Boolean) value));
                        } else {
                            throw new IllegalArgumentException(("property \"valid\" is of type \"java.lang.Boolean\", but got "+ value.getClass().toString()));
                        }
                        return true;
                    } else {
                        if ("domain".equals(name)) {
                            if (value instanceof String) {
                                setDomain(((String) value));
                            } else {
                                throw new IllegalArgumentException(("property \"domain\" is of type \"java.lang.String\", but got "+ value.getClass().toString()));
                            }
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
    }

    protected Object declaredPropertyOrNotFound(String name, Object notFoundValue) {
        if ("id".equals(name)) {
            return getId();
        } else {
            if ("value".equals(name)) {
                return getValue();
            } else {
                if ("type".equals(name)) {
                    return getType();
                } else {
                    if ("valid".equals(name)) {
                        return getValid();
                    } else {
                        if ("domain".equals(name)) {
                            return getDomain();
                        } else {
                            return notFoundValue;
                        }
                    }
                }
            }
        }
    }

    @SuppressWarnings({
        "unchecked"
    })
    public<T >T get(String name) {
        Object value = declaredPropertyOrNotFound(name, DataSet.NOT_FOUND_VALUE);
        if (DataSet.NOT_FOUND_VALUE!= value) {
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
        return new HashCodeBuilder().append(id).append(value).append(type).append(valid).append(domain).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DataSet) == false) {
            return false;
        }
        DataSet rhs = ((DataSet) other);
        return new EqualsBuilder().append(id, rhs.id).append(value, rhs.value).append(type, rhs.type).append(valid, rhs.valid).append(domain, rhs.domain).isEquals();
    }

}
