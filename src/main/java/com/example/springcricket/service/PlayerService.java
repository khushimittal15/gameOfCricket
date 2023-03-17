package com.example.springcricket.service;

import com.example.springcricket.NotFoundException;
import com.example.springcricket.dto.PlayerDTO;
import com.example.springcricket.entities.BowlerPerformance;
import com.example.springcricket.entities.Player;
import com.example.springcricket.entities.Status;
import com.example.springcricket.repository.IPlayerRepository;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.InsertOneModel;
import com.mongodb.client.model.UpdateManyModel;
import com.mongodb.client.model.WriteModel;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PlayerService implements IPlayerService {
    @Autowired
    IPlayerRepository playerRepo;
    @Autowired
    private MongoOperations mongoTemplate;
    @Override
    public String addPlayers(List<PlayerDTO> playerDTOs){
        MongoCollection<Document> postsCollection = mongoTemplate.getCollection("players");

        List<WriteModel<Document>> list = new ArrayList<>() ;
        String playersIds = "" ;
        for(int index=0 ; index<playerDTOs.size() ; index++ ){
            PlayerDTO playerdto = playerDTOs.get(index) ;
            UUID playerId = UUID.randomUUID() ;
            playersIds+= String.valueOf(playerId)+"   " ;

            Document document = new Document("_id",String.valueOf(playerId))
                    .append("playerName",playerdto.getPlayerName())
                    .append("playerType",playerdto.getPlayerType())
                    .append("playerAge",playerdto.getPlayerAge())
                    .append("status",Status.PRESENT)
                    .append("matchPlayed",0)
                    .append("runsGiven",0)
                    .append("oversBowled",0)
                    .append("wicketsTaken",0)
                    .append("runsScored",0)
                    .append("ballsPlayed",0)
                    .append("strikeRate",0)
                    .append("fours",0)
                    .append("sixes",0);
//                    .append("inSomeTeam",false);
            list.add(new InsertOneModel<>(document));

        }
//        System.out.println(list);
        postsCollection.bulkWrite(list) ;
        return "Players Added Successfully and their ids are " + playersIds ;

    }
    @Override
    public String addPlayer(PlayerDTO playerdto) {
        UUID playerId = UUID.randomUUID() ;
        Player player = Player.builder()
                .playerId(String.valueOf(playerId))
                .playerName(playerdto.getPlayerName())
                .playerType(playerdto.getPlayerType())
                .playerAge(playerdto.getPlayerAge())
                .status(Status.PRESENT)
//                .inSomeTeam(false)
                .build();

        if(player == null)
            System.out.println("Player is empty");

        playerRepo.save(player) ;
        return playerId + " is the playerId of the new player";
    }

    @Override
    public List<Player> getPlayers() {
        return playerRepo.findAll();
    }

    @Override
    public void updateBatsman(String playerId, int batsmanScore, int batsmanFours, int batsmanSixes, int batsmanBallsUsed) {
        Player player = playerRepo.findById(playerId).orElse(null);
        if(player != null){
            int previousScore = player.getRunsScored() ;
            int previousBallsPlayed = player.getBallsPlayed() ;
            int previousFours = player.getFours() ;
            int previousSixes = player.getSixes() ;
            player.setRunsScored(previousScore + batsmanScore);
            player.setBallsPlayed(previousBallsPlayed + batsmanBallsUsed);
            player.setFours(previousFours+batsmanFours);
            player.setSixes(previousSixes+batsmanSixes);
            player.setMatchPlayed(player.getMatchPlayed()+1);
            double strikeRate = 0.0 ;
            try{
                strikeRate = ((double)previousScore+batsmanScore)/(previousBallsPlayed+batsmanBallsUsed)*100.0 ;
            }
            catch (Exception e){
                System.out.println("Divide by 0.");
            }

            player.setStrikeRate(strikeRate);
            playerRepo.save(player) ;

        }
        else{
            throw new NotFoundException("Player does not exist") ;
        }
    }

    @Override
    public void updateBowler(List<BowlerPerformance> bowlerPerformances) {
        MongoCollection<Document> postsCollection = mongoTemplate.getCollection("players");
        List<WriteModel<Document>> writeOperations = new ArrayList<>();

        for(int index=0 ; index<bowlerPerformances.size() ; index++ ){
            writeOperations.add(new UpdateManyModel<Document>(new Document("_id", bowlerPerformances.get(index).getPlayerId()),
                    new Document("$set", new Document("runsGiven",0).append("oversBowled",0).append("wicketsTaken",0))));




        }
//        System.out.println(list);
        postsCollection.bulkWrite(writeOperations) ;
    }

    @Override
    public Player getPlayerById(String playerID) {
        return playerRepo.findById(playerID).orElseThrow(() -> new NotFoundException("Player ID not found"));



    }
}
