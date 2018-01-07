package ad.starter.campaign;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Campaign {

    @Id
    private String partnerId;
    private int duration;
    private String adContent;
    private LocalDateTime creationDatetime;

    public Campaign(String partnerId, int duration, String adContent, LocalDateTime creationDatetime) {
        this.partnerId = partnerId;
        this.duration = duration;
        this.adContent = adContent;
        this.creationDatetime = creationDatetime;
    }

    public Campaign(){
        this.partnerId = partnerId;
        this.duration = duration;
        this.adContent = adContent;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public int getDuration() {
        return duration;
    }

    public String getAdContent() {
        return adContent;
    }

    public LocalDateTime getCreationDatetime() {
        return creationDatetime;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setAdContent(String adContent) {
        this.adContent = adContent;
    }

    public void setCreationDatetime(LocalDateTime creationDatetime) {
        this.creationDatetime = creationDatetime;
    }
}
