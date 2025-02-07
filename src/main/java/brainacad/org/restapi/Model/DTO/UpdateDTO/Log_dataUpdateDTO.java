package brainacad.org.restapi.Model.DTO.UpdateDTO;
import brainacad.org.restapi.Model.Entity.Level;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Log_dataUpdateDTO
{
    private Long id;
    private String level_name;
    private String src;
    private String message;

    public String getLevel_name() {return level_name;}
    public void setLevel_name(String level_name) {this.level_name = level_name;}
    public String getSrc() {return src;}
    public void setSrc(String src) {this.src = src;}
    public String getMessage() {return message;}
    public void setMessage(String message) {this.message = message;}
    public Long getId() {return id;}
    public void setId(Long id) { this.id = id;}
}
