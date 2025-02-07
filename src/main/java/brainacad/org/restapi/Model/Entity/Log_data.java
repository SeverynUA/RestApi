package brainacad.org.restapi.Model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "log_data")
public class Log_data
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "level_id", referencedColumnName = "id", nullable = false)
    private Level level;

    @NotNull
    @Column(name = "src", nullable = false)
    private String src;

    @NotNull
    @Column(name = "message", nullable = false)
    private String message;

    public Level getLevel() {return level;}
    public void setLevel(Level level) {this.level = level;}
    public String getSrc() {return src;}
    public void setSrc(String src) {this.src = src;}
    public String getMessage() {return message;}
    public void setMessage(String message) {this.message = message;}
    public Long getId() {return id;}
    public void setId(Long id) { this.id = id;}
}
