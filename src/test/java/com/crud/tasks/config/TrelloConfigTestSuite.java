package com.crud.tasks.config;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloConfigTestSuite {

    @Autowired
    TrelloConfig trelloConfig;

    @Test
    public void getTrelloConfigTest(){
        //Given

        //When
        String trelloApiEndpointFromTrelloConfig = trelloConfig.getTrelloApiEndpoint();
        String trelloAppKeyFromTrelloConfig = trelloConfig.getTrelloAppKey();
        String trelloTokenFromTrelloConfig = trelloConfig.getTrelloToken();
        String trelloUsernameFromTrelloConfig = trelloConfig.getTrelloUsername();
        //Then
        Assert.assertNotNull(trelloApiEndpointFromTrelloConfig);
        Assert.assertNotNull(trelloAppKeyFromTrelloConfig);
        Assert.assertNotNull(trelloTokenFromTrelloConfig);
        Assert.assertNotNull(trelloUsernameFromTrelloConfig);
    }
}
