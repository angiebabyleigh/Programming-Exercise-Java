package com.containerstore.whereis.dao;

import org.springframework.stereotype.Component;

@Component
public class WhereIsConferenceRooms {

    public String locationOf(String query) {
        String location;

        switch (query.trim().toLowerCase()) {
            case "fill their baskets":
            case "service selection price":
            case "man in the desert":
            case "air of excitement":
                location = "in the vendor conference area (off of reception)";
                break;
            case "data central":
                location = "in the Information Systems area";
                break;
            case "perfect product presentation":
            case "main and main":
                location = "at the north end of the Information Systems area";
                break;
            case "1 great = 3 good":
            case "intuition does not come to an unprepared mind":
                location = "off the atrium, behind reception";
                break;
            case "gumby":
                location = "where gumby has always been located...c'mon!";
                break;
            case "contain yourself":
                location = "upstairs, south end, adjacent to CSD";
                break;
            case "we love our employees":
                location = "upstairs, south end, adjacent to CSD (seating area in front of Contain Yourself)";
                break;
            case "all eyes on elfa":
                location = "upstairs, southwest corner";
                break;
            case "service = selling":
            case "fun and functional":
                location = "upstairs, southwest corner, adjacent to loss prevention";
                break;
            case "communication is leadership":
                location = "upstairs, northwest corner, adjacent to the executive suite";
                break;
            case "we sell the hard stuff":
            case "blue sky":
                location = "up the stairs, turn right (adjacent to merchandising)";
                break;
            case "list conference rooms":
            	location = 	"fill their baskets\n" +
            				"service selection price\n" +
            				"man in the desert\n" +
            				"air of excitement\n" +
            				"data central\n" +
            				"perfect product presentation\n" +
            				"main and main\n" +
            				"1 great = 3 good\n" +
            				"intuition does not come to an unprepared mind\n" +
            				"gumby\n" +
            				"contain yourself\n" +
            				"we love our employees\n" +
            				"all eyes on elfa\n" +
            				"service = selling\n" +
            				"fun and functional\n" +
            				"communication is leadership\n" +
            				"we sell the hard stuff\n" +
            				"blue sky";
            	break;
            default:
                location = "somewhere, but I don't know where";
                break;
        }
        
        return String.format("%s is located %s", query, location);
    }
}
