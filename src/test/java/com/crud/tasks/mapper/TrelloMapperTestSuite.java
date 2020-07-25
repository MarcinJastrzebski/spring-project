package com.crud.tasks.mapper;

import com.crud.tasks.domain.TrelloCard;
import com.crud.tasks.domain.TrelloCardDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(MockitoJUnitRunner.class)
public class TrelloMapperTestSuite {

    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    public void allMappersTest(){
        //Given
//        TrelloList trelloList = new TrelloList("1","list", false);
//        List<TrelloList> listOfTrelloLists = new ArrayList<>();
//        listOfTrelloLists.add(trelloList);
//        TrelloBoard trelloBoard = new TrelloBoard("1","board",listOfTrelloLists);
//        List<TrelloBoard> listOfTrelloBoards = new ArrayList<>();

        TrelloCard trelloCard = new TrelloCard("card","desc","1","1");
        System.out.println(trelloCard.getName());
        //When
//        List<TrelloListDto> listOfTrelloDtoLists = trelloMapper.mapToListDto(listOfTrelloLists);
//        List<TrelloBoardDto> listOfTrelloBoardDto = trelloMapper.mapToBoardsDto(listOfTrelloBoards);
        TrelloCardDto trelloCardDto =  trelloMapper.mapToCardDto(trelloCard);
        System.out.println(trelloCardDto.getName());
        //Then
        //Assert.assertEquals(trelloCard.getName(),trelloCardDto.getName());

        //Assert.assertEquals(listOfTrelloBoardDto.get(1).getName(),listOfTrelloBoards.get(1).getName());
        //Assert.assertEquals(listOfTrelloBoardDto.get(1).getName(),listOfTrelloBoards.get(1).getName());
    }

}
