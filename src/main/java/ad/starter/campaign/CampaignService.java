package ad.starter.campaign;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CampaignService {

    @Autowired
    private CampaignRepository campaignRepository;


    public List<Campaign> getAllCampaigns(){
        List<Campaign> campaigns = new ArrayList<>();
        campaignRepository.findAll()
        .forEach(campaigns::add);// storing values in the iterable into campaigns list;
        return campaigns;
    }

    public Campaign getCampaign(String partnerId) throws NoActiveAdException {
        LocalDateTime campaignCreationPlusDuration = campaignRepository.findOne(partnerId).getCreationDatetime().plusSeconds(
                campaignRepository.findOne(partnerId).getDuration());

        LocalDateTime currentDatetime = LocalDateTime.now();

        if(campaignCreationPlusDuration.compareTo(currentDatetime) >= 0){
            return campaignRepository.findOne(partnerId);
        }
        else throw new NoActiveAdException("no active ad found for given id");

    }

    public String addCampaign(Campaign campaign){
        if(campaignRepository.exists(campaign.getPartnerId())){
            return "an active campaign already exists for " + campaign.getPartnerId();
        }
        campaignRepository.save(campaign);
        return "your campaign has been created for " + campaign.getPartnerId();
    }
}
