package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloMapperTestSuite {

    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    public void allToDtoMappersTest(){
        //Given
        List<TrelloList> listOfTrelloLists = new ArrayList<>();
        listOfTrelloLists.add(new TrelloList("1","list", false));

        List<TrelloBoard> listOfTrelloBoards = new ArrayList<>();
        listOfTrelloBoards.add(new TrelloBoard("1","board",listOfTrelloLists));

        TrelloCard trelloCard = new TrelloCard("card","desc","1","1");

        //When
        List<TrelloListDto> listOfTrelloDtoLists = trelloMapper.mapToListDto(listOfTrelloLists);
        List<TrelloBoardDto> listOfTrelloDtoBoards = trelloMapper.mapToBoardsDto(listOfTrelloBoards);
        TrelloCardDto trelloCardDto =  trelloMapper.mapToCardDto(trelloCard);

        //Then
        Assert.assertEquals(trelloCard.getName(),trelloCardDto.getName());
        Assert.assertEquals(listOfTrelloDtoBoards.get(0).getName(),listOfTrelloBoards.get(0).getName());
        Assert.assertEquals(listOfTrelloDtoLists.get(0).getName(),listOfTrelloLists.get(0).getName());
    }

    @Test
    public void allRegularMappersTest(){
        //Given
        List<TrelloListDto> listOfTrelloDtoLists = new ArrayList<>();
        listOfTrelloDtoLists.add(new TrelloListDto("1","list", false));

        List<TrelloBoardDto> listOfTrelloDtoBoards = new ArrayList<>();
        listOfTrelloDtoBoards.add(new TrelloBoardDto("1","board",listOfTrelloDtoLists));

        TrelloCardDto trelloCardDto = new TrelloCardDto("card","desc","1","1");

        //When
        List<TrelloList> listOfTrelloLists = trelloMapper.mapToList(listOfTrelloDtoLists);
        List<TrelloBoard> listOfTrelloBoards = trelloMapper.mapToBoards(listOfTrelloDtoBoards);
        TrelloCard trelloCard =  trelloMapper.mapToCard(trelloCardDto);
        //Then
        Assert.assertEquals(trelloCard.getName(),trelloCardDto.getName());
        Assert.assertEquals(listOfTrelloDtoBoards.get(0).getName(),listOfTrelloBoards.get(0).getName());
        Assert.assertEquals(listOfTrelloDtoLists.get(0).getName(),listOfTrelloLists.get(0).getName());
    }

}
