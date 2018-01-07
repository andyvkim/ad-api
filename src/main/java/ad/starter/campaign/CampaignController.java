package ad.starter.campaign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CampaignController {

    @Autowired
    private CampaignService campaignService;

    @RequestMapping(value = "/ads")
    public List<Campaign> getAllCampaigns(){
        return campaignService.getAllCampaigns();
    }

    @RequestMapping(value = "/ads/{partnerId}")
    public Campaign getCampaign(@PathVariable String partnerId){
        Campaign tempCampaign = null;
        try {
            tempCampaign = campaignService.getCampaign(partnerId);
        } catch (NoActiveAdException e) {
            e.printStackTrace();
        }
        return tempCampaign;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/ads")
    public String addCampaign(@RequestBody Campaign campaign){
        return campaignService.addCampaign(campaign);
    }
}
