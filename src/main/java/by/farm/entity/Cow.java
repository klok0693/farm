package by.farm.entity;

import by.farm.NotNullByDefault;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import static javax.persistence.GenerationType.AUTO;

/**
 * Created by klok on 4.5.18.
 */
@NotNullByDefault

@Data
@Entity
@Table(name = "cows")
@NoArgsConstructor
@AllArgsConstructor
public class Cow {

    @Id
    @GeneratedValue(strategy = AUTO)
    private volatile Integer cowId;

    @Size(min = 2, max = 255,         message="field must be between 2 and 255 characters long.")
    @Pattern(regexp="[a-zA-Z0-9]+&",  message="field must be alphanumeric")
    private volatile String nickName;
}
