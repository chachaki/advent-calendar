package advnetcalendar.model.user;

import advnetcalendar.model.user.validation.OnRegister;
import advnetcalendar.model.user.validation.OnUpdate;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

public class PhoneNumber {
    @NotBlank(message = "電話番号を入力してください", groups = OnUpdate.class)
    @Pattern(regexp = "([0-9]{2,4}-[0-9]{2,4}-[0-9]{2,4})?", message = "xx-xxxx-xxxxの形式で入力してください", groups = {OnRegister.class, OnUpdate.class})
    String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
