package adventcalendar.model.theme;

import javax.validation.Valid;

public class ThemeId {

    private Integer id;
    
    public ThemeId(Integer value) {
        this.id = value;
    }
    
    public Integer getId(){
        return this.id;
    }
    
    public void setId(Integer value){
        this.id = value;
    }
}
