package adventcalendar.model.theme;

import adventcalendar.model.theme.calendar.Calendar;
import adventcalendar.model.theme.organizer.Organizer;

import javax.validation.Valid;

/**
 * Created by sasakimasayuki on 15/09/21.
 */
public class Theme {
    ThemeId id;
    ThemeTitle title;
    ThemeDescription description;
    Calendar calendar;
    
    Organizer organizer;
}
