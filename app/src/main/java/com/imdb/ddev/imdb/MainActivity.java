package com.imdb.ddev.imdb;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ArrayList<HashMap<String, String>> data;

    String json = "{  \n" +
            "    \"movies\":[  \n" +
            "        {  \n" +
            "            \"Title\":\"The Shawshank Redemption\",\n" +
            "            \"Year\":\"1994\",\n" +
            "            \"Rated\":\"R\",\n" +
            "            \"Released\":\"14 Oct 1994\",\n" +
            "            \"Runtime\":\"142 min\",\n" +
            "            \"Genre\":\"Crime, Drama\",\n" +
            "            \"Director\":\"Frank Darabont\",\n" +
            "            \"Writer\":\"Stephen King (short story \\\"Rita Hayworth and Shawshank Redemption\\\"), Frank Darabont (screenplay)\",\n" +
            "            \"Actors\":\"Tim Robbins, Morgan Freeman, Bob Gunton, William Sadler\",\n" +
            "            \"Plot\":\"Chronicles the experiences of a formerly successful banker as a prisoner in the gloomy jailhouse of Shawshank after being found guilty of a crime he did not commit. The film portrays the man's unique way of dealing with his new, torturous life; along the way he befriends a number of fellow prisoners, most notably a wise long-term inmate named Red.\",\n" +
            "            \"Language\":\"English\",\n" +
            "            \"Country\":\"USA\",\n" +
            "            \"Awards\":\"Nominated for 7 Oscars. Another 19 wins & 30 nominations.\",\n" +
            "            \"Poster\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BODU4MjU4NjIwNl5BMl5BanBnXkFtZTgwMDU2MjEyMDE@._V1_SX300.jpg\",\n" +
            "            \"Ratings\":[  \n" +
            "                {  \n" +
            "                    \"Source\":\"Internet Movie Database\",\n" +
            "                    \"Value\":\"9.3/10\"\n" +
            "                },\n" +
            "                {  \n" +
            "                    \"Source\":\"Rotten Tomatoes\",\n" +
            "                    \"Value\":\"91%\"\n" +
            "                },\n" +
            "                {  \n" +
            "                    \"Source\":\"Metacritic\",\n" +
            "                    \"Value\":\"80/100\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"Metascore\":\"80\",\n" +
            "            \"imdbRating\":\"9.3\",\n" +
            "            \"imdbVotes\":\"1,786,262\",\n" +
            "            \"imdbID\":\"tt0111161\",\n" +
            "            \"Type\":\"movie\",\n" +
            "            \"DVD\":\"27 Jan 1998\",\n" +
            "            \"BoxOffice\":\"N/A\",\n" +
            "            \"Production\":\"Columbia Pictures\",\n" +
            "            \"Website\":\"N/A\",\n" +
            "            \"Response\":\"True\"\n" +
            "        },\n" +
            "        {  \n" +
            "            \"Title\":\"The Godfather\",\n" +
            "            \"Year\":\"1972\",\n" +
            "            \"Rated\":\"R\",\n" +
            "            \"Released\":\"24 Mar 1972\",\n" +
            "            \"Runtime\":\"175 min\",\n" +
            "            \"Genre\":\"Crime, Drama\",\n" +
            "            \"Director\":\"Francis Ford Coppola\",\n" +
            "            \"Writer\":\"Mario Puzo (screenplay), Francis Ford Coppola (screenplay), Mario Puzo (novel)\",\n" +
            "            \"Actors\":\"Marlon Brando, Al Pacino, James Caan, Richard S. Castellano\",\n" +
            "            \"Plot\":\"When the aging head of a famous crime family decides to transfer his position to one of his subalterns, a series of unfortunate events start happening to the family, and a war begins between all the well-known families leading to insolence, deportation, murder and revenge, and ends with the favorable successor being finally chosen.\",\n" +
            "            \"Language\":\"English, Italian, Latin\",\n" +
            "            \"Country\":\"USA\",\n" +
            "            \"Awards\":\"Won 3 Oscars. Another 23 wins & 27 nominations.\",\n" +
            "            \"Poster\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BZTRmNjQ1ZDYtNDgzMy00OGE0LWE4N2YtNTkzNWQ5ZDhlNGJmL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SX300.jpg\",\n" +
            "            \"Ratings\":[  \n" +
            "                {  \n" +
            "                    \"Source\":\"Internet Movie Database\",\n" +
            "                    \"Value\":\"9.2/10\"\n" +
            "                },\n" +
            "                {  \n" +
            "                    \"Source\":\"Rotten Tomatoes\",\n" +
            "                    \"Value\":\"99%\"\n" +
            "                },\n" +
            "                {  \n" +
            "                    \"Source\":\"Metacritic\",\n" +
            "                    \"Value\":\"100/100\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"Metascore\":\"100\",\n" +
            "            \"imdbRating\":\"9.2\",\n" +
            "            \"imdbVotes\":\"1,219,320\",\n" +
            "            \"imdbID\":\"tt0068646\",\n" +
            "            \"Type\":\"movie\",\n" +
            "            \"DVD\":\"09 Oct 2001\",\n" +
            "            \"BoxOffice\":\"N/A\",\n" +
            "            \"Production\":\"Paramount Pictures\",\n" +
            "            \"Website\":\"http://www.thegodfather.com\",\n" +
            "            \"Response\":\"True\"\n" +
            "        },\n" +
            "        {  \n" +
            "            \"Title\":\"The Godfather: Part II\",\n" +
            "            \"Year\":\"1974\",\n" +
            "            \"Rated\":\"R\",\n" +
            "            \"Released\":\"20 Dec 1974\",\n" +
            "            \"Runtime\":\"202 min\",\n" +
            "            \"Genre\":\"Crime, Drama\",\n" +
            "            \"Director\":\"Francis Ford Coppola\",\n" +
            "            \"Writer\":\"Francis Ford Coppola (screenplay), Mario Puzo (screenplay), Mario Puzo (novel)\",\n" +
            "            \"Actors\":\"Al Pacino, Robert Duvall, Diane Keaton, Robert De Niro\",\n" +
            "            \"Plot\":\"The continuing saga of the Corleone crime family tells the story of a young Vito Corleone growing up in Sicily and in 1910s New York; and follows Michael Corleone in the 1950s as he attempts to expand the family business into Las Vegas, Hollywood and Cuba.\",\n" +
            "            \"Language\":\"English, Italian, Spanish, Latin, Sicilian\",\n" +
            "            \"Country\":\"USA\",\n" +
            "            \"Awards\":\"Won 6 Oscars. Another 10 wins & 20 nominations.\",\n" +
            "            \"Poster\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BMjZiNzIxNTQtNDc5Zi00YWY1LThkMTctMDgzYjY4YjI1YmQyL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SX300.jpg\",\n" +
            "            \"Ratings\":[  \n" +
            "                {  \n" +
            "                    \"Source\":\"Internet Movie Database\",\n" +
            "                    \"Value\":\"9.0/10\"\n" +
            "                },\n" +
            "                {  \n" +
            "                    \"Source\":\"Rotten Tomatoes\",\n" +
            "                    \"Value\":\"97%\"\n" +
            "                },\n" +
            "                {  \n" +
            "                    \"Source\":\"Metacritic\",\n" +
            "                    \"Value\":\"80/100\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"Metascore\":\"80\",\n" +
            "            \"imdbRating\":\"9.0\",\n" +
            "            \"imdbVotes\":\"839,135\",\n" +
            "            \"imdbID\":\"tt0071562\",\n" +
            "            \"Type\":\"movie\",\n" +
            "            \"DVD\":\"24 May 2005\",\n" +
            "            \"BoxOffice\":\"N/A\",\n" +
            "            \"Production\":\"Paramount Pictures\",\n" +
            "            \"Website\":\"http://www.thegodfather.com/\",\n" +
            "            \"Response\":\"True\"\n" +
            "        },\n" +
            "        {  \n" +
            "            \"Title\":\"The Dark Knight\",\n" +
            "            \"Year\":\"2008\",\n" +
            "            \"Rated\":\"PG-13\",\n" +
            "            \"Released\":\"18 Jul 2008\",\n" +
            "            \"Runtime\":\"152 min\",\n" +
            "            \"Genre\":\"Action, Crime, Drama\",\n" +
            "            \"Director\":\"Christopher Nolan\",\n" +
            "            \"Writer\":\"Jonathan Nolan (screenplay), Christopher Nolan (screenplay), Christopher Nolan (story), David S. Goyer (story), Bob Kane (characters)\",\n" +
            "            \"Actors\":\"Christian Bale, Heath Ledger, Aaron Eckhart, Michael Caine\",\n" +
            "            \"Plot\":\"Set within a year after the events of Batman Begins, Batman, Lieutenant James Gordon, and new district attorney Harvey Dent successfully begin to round up the criminals that plague Gotham City until a mysterious and sadistic criminal mastermind known only as the Joker appears in Gotham, creating a new wave of chaos. Batman's struggle against the Joker becomes deeply personal, forcing him to \\\"confront everything he believes\\\" and improve his technology to stop him. A love triangle develops between Bruce Wayne, Dent and Rachel Dawes.\",\n" +
            "            \"Language\":\"English, Mandarin\",\n" +
            "            \"Country\":\"USA, UK\",\n" +
            "            \"Awards\":\"Won 2 Oscars. Another 147 wins & 144 nominations.\",\n" +
            "            \"Poster\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_SX300.jpg\",\n" +
            "            \"Ratings\":[  \n" +
            "                {  \n" +
            "                    \"Source\":\"Internet Movie Database\",\n" +
            "                    \"Value\":\"9.0/10\"\n" +
            "                },\n" +
            "                {  \n" +
            "                    \"Source\":\"Rotten Tomatoes\",\n" +
            "                    \"Value\":\"94%\"\n" +
            "                },\n" +
            "                {  \n" +
            "                    \"Source\":\"Metacritic\",\n" +
            "                    \"Value\":\"82/100\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"Metascore\":\"82\",\n" +
            "            \"imdbRating\":\"9.0\",\n" +
            "            \"imdbVotes\":\"1,768,567\",\n" +
            "            \"imdbID\":\"tt0468569\",\n" +
            "            \"Type\":\"movie\",\n" +
            "            \"DVD\":\"09 Dec 2008\",\n" +
            "            \"BoxOffice\":\"$533,316,061.00\",\n" +
            "            \"Production\":\"Warner Bros. Pictures/Legendary\",\n" +
            "            \"Website\":\"http://thedarkknight.warnerbros.com/\",\n" +
            "            \"Response\":\"True\"\n" +
            "        },\n" +
            "        {  \n" +
            "            \"Title\":\"The Lord of the Rings: The Return of the King\",\n" +
            "            \"Year\":\"2003\",\n" +
            "            \"Rated\":\"PG-13\",\n" +
            "            \"Released\":\"17 Dec 2003\",\n" +
            "            \"Runtime\":\"201 min\",\n" +
            "            \"Genre\":\"Adventure, Drama, Fantasy\",\n" +
            "            \"Director\":\"Peter Jackson\",\n" +
            "            \"Writer\":\"J.R.R. Tolkien (novel), Fran Walsh (screenplay), Philippa Boyens (screenplay), Peter Jackson (screenplay)\",\n" +
            "            \"Actors\":\"Noel Appleby, Ali Astin, Sean Astin, David Aston\",\n" +
            "            \"Plot\":\"The final confrontation between the forces of good and evil fighting for control of the future of Middle-earth. Hobbits Frodo and Sam reach Mordor in their quest to destroy the \\\"one ring\\\", while Aragorn leads the forces of good against Sauron's evil army at the stone city of Minas Tirith.\",\n" +
            "            \"Language\":\"English, Quenya, Old English, Sindarin\",\n" +
            "            \"Country\":\"USA, New Zealand\",\n" +
            "            \"Awards\":\"Won 11 Oscars. Another 190 wins & 119 nominations.\",\n" +
            "            \"Poster\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BYWY1ZWQ5YjMtMDE0MS00NWIzLWE1M2YtODYzYTk2OTNlYWZmXkEyXkFqcGdeQXVyNDUyOTg3Njg@._V1_SX300.jpg\",\n" +
            "            \"Ratings\":[  \n" +
            "                {  \n" +
            "                    \"Source\":\"Internet Movie Database\",\n" +
            "                    \"Value\":\"8.9/10\"\n" +
            "                },\n" +
            "                {  \n" +
            "                    \"Source\":\"Rotten Tomatoes\",\n" +
            "                    \"Value\":\"95%\"\n" +
            "                },\n" +
            "                {  \n" +
            "                    \"Source\":\"Metacritic\",\n" +
            "                    \"Value\":\"94/100\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"Metascore\":\"94\",\n" +
            "            \"imdbRating\":\"8.9\",\n" +
            "            \"imdbVotes\":\"1,280,900\",\n" +
            "            \"imdbID\":\"tt0167260\",\n" +
            "            \"Type\":\"movie\",\n" +
            "            \"DVD\":\"25 May 2004\",\n" +
            "            \"BoxOffice\":\"$364,000,000.00\",\n" +
            "            \"Production\":\"New Line Cinema\",\n" +
            "            \"Website\":\"http://www.lordoftherings.net/\",\n" +
            "            \"Response\":\"True\"\n" +
            "        },\n" +
            "        {  \n" +
            "            \"Title\":\"The Good, the Bad and the Ugly\",\n" +
            "            \"Year\":\"1966\",\n" +
            "            \"Rated\":\"APPROVED\",\n" +
            "            \"Released\":\"29 Dec 1967\",\n" +
            "            \"Runtime\":\"161 min\",\n" +
            "            \"Genre\":\"Western\",\n" +
            "            \"Director\":\"Sergio Leone\",\n" +
            "            \"Writer\":\"Luciano Vincenzoni (story), Sergio Leone (story), Agenore Incrocci (screenplay), Furio Scarpelli (screenplay), Luciano Vincenzoni (screenplay), Sergio Leone (screenplay), Mickey Knox (English version by)\",\n" +
            "            \"Actors\":\"Eli Wallach, Clint Eastwood, Lee Van Cleef, Aldo Giuffrè\",\n" +
            "            \"Plot\":\"Blondie (The Good) is a professional gunslinger who is out trying to earn a few dollars. Angel Eyes (The Bad) is a hit man who always commits to a task and sees it through, as long as he is paid to do so. And Tuco (The Ugly) is a wanted outlaw trying to take care of his own hide. Tuco and Blondie share a partnership together making money off Tuco's bounty, but when Blondie unties the partnership, Tuco tries to hunt down Blondie. When Blondie and Tuco come across a horse carriage loaded with dead bodies, they soon learn from the only survivor (Bill Carson) that he and a few other men have buried a stash of gold in a cemetery. Unfortunately Carson dies and Tuco only finds out the name of the cemetery, while Blondie finds out the name on the grave. Now the two must keep each other alive in order to find the gold. Angel Eyes (who had been looking for Bill Carson) discovers that Tuco and Blondie met with Carson and knows they know the location of the gold. All he needs is for the two to lead him to it. Now The Good, The Bad and The Ugly must all battle it out to get their hands on $200,000 worth of gold.\",\n" +
            "            \"Language\":\"Italian\",\n" +
            "            \"Country\":\"Italy, Spain, West Germany, USA\",\n" +
            "            \"Awards\":\"1 win & 2 nominations.\",\n" +
            "            \"Poster\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BOTQ5NDI3MTI4MF5BMl5BanBnXkFtZTgwNDQ4ODE5MDE@._V1_SX300.jpg\",\n" +
            "            \"Ratings\":[  \n" +
            "                {  \n" +
            "                    \"Source\":\"Internet Movie Database\",\n" +
            "                    \"Value\":\"8.9/10\"\n" +
            "                },\n" +
            "                {  \n" +
            "                    \"Source\":\"Rotten Tomatoes\",\n" +
            "                    \"Value\":\"97%\"\n" +
            "                },\n" +
            "                {  \n" +
            "                    \"Source\":\"Metacritic\",\n" +
            "                    \"Value\":\"90/100\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"Metascore\":\"90\",\n" +
            "            \"imdbRating\":\"8.9\",\n" +
            "            \"imdbVotes\":\"528,446\",\n" +
            "            \"imdbID\":\"tt0060196\",\n" +
            "            \"Type\":\"movie\",\n" +
            "            \"DVD\":\"18 Nov 1997\",\n" +
            "            \"BoxOffice\":\"N/A\",\n" +
            "            \"Production\":\"United Artists\",\n" +
            "            \"Website\":\"N/A\",\n" +
            "            \"Response\":\"True\"\n" +
            "        },\n" +
            "        {  \n" +
            "            \"Title\":\"Fight Club\",\n" +
            "            \"Year\":\"1999\",\n" +
            "            \"Rated\":\"R\",\n" +
            "            \"Released\":\"15 Oct 1999\",\n" +
            "            \"Runtime\":\"139 min\",\n" +
            "            \"Genre\":\"Drama\",\n" +
            "            \"Director\":\"David Fincher\",\n" +
            "            \"Writer\":\"Chuck Palahniuk (novel), Jim Uhls (screenplay)\",\n" +
            "            \"Actors\":\"Edward Norton, Brad Pitt, Meat Loaf, Zach Grenier\",\n" +
            "            \"Plot\":\"A nameless first person narrator (Edward Norton) attends support groups in attempt to subdue his emotional state and relieve his insomniac state. When he meets Marla (Helena Bonham Carter), another fake attendee of support groups, his life seems to become a little more bearable. However when he associates himself with Tyler (Brad Pitt) he is dragged into an underground fight club and soap making scheme. Together the two men spiral out of control and engage in competitive rivalry for love and power. When the narrator is exposed to the hidden agenda of Tyler's fight club, he must accept the awful truth that Tyler may not be who he says he is.\",\n" +
            "            \"Language\":\"English\",\n" +
            "            \"Country\":\"USA, Germany\",\n" +
            "            \"Awards\":\"Nominated for 1 Oscar. Another 10 wins & 31 nominations.\",\n" +
            "            \"Poster\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BZGY5Y2RjMmItNDg5Yy00NjUwLThjMTEtNDc2OGUzNTBiYmM1XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SX300.jpg\",\n" +
            "            \"Ratings\":[  \n" +
            "                {  \n" +
            "                    \"Source\":\"Internet Movie Database\",\n" +
            "                    \"Value\":\"8.8/10\"\n" +
            "                },\n" +
            "                {  \n" +
            "                    \"Source\":\"Rotten Tomatoes\",\n" +
            "                    \"Value\":\"79%\"\n" +
            "                },\n" +
            "                {  \n" +
            "                    \"Source\":\"Metacritic\",\n" +
            "                    \"Value\":\"66/100\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"Metascore\":\"66\",\n" +
            "            \"imdbRating\":\"8.8\",\n" +
            "            \"imdbVotes\":\"1,425,849\",\n" +
            "            \"imdbID\":\"tt0137523\",\n" +
            "            \"Type\":\"movie\",\n" +
            "            \"DVD\":\"06 Jun 2000\",\n" +
            "            \"BoxOffice\":\"N/A\",\n" +
            "            \"Production\":\"20th Century Fox\",\n" +
            "            \"Website\":\"http://www.foxmovies.com/fightclub/\",\n" +
            "            \"Response\":\"True\"\n" +
            "        },\n" +
            "        {  \n" +
            "            \"Title\":\"Star Wars: Episode V - The Empire Strikes Back\",\n" +
            "            \"Year\":\"1980\",\n" +
            "            \"Rated\":\"PG\",\n" +
            "            \"Released\":\"20 Jun 1980\",\n" +
            "            \"Runtime\":\"124 min\",\n" +
            "            \"Genre\":\"Action, Adventure, Fantasy\",\n" +
            "            \"Director\":\"Irvin Kershner\",\n" +
            "            \"Writer\":\"Leigh Brackett (screenplay), Lawrence Kasdan (screenplay), George Lucas (story by)\",\n" +
            "            \"Actors\":\"Mark Hamill, Harrison Ford, Carrie Fisher, Billy Dee Williams\",\n" +
            "            \"Plot\":\"Luke Skywalker, Han Solo, Princess Leia and Chewbacca face attack by the Imperial forces and its AT-AT walkers on the ice planet Hoth. While Han and Leia escape in the Millennium Falcon, Luke travels to Dagobah in search of Yoda. Only with the Jedi master's help will Luke survive when the dark side of the Force beckons him into the ultimate duel with Darth Vader.\",\n" +
            "            \"Language\":\"English\",\n" +
            "            \"Country\":\"USA\",\n" +
            "            \"Awards\":\"Won 1 Oscar. Another 21 wins & 19 nominations.\",\n" +
            "            \"Poster\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BYmViY2M2MTYtY2MzOS00YjQ1LWIzYmEtOTBiNjhlMGM0NjZjXkEyXkFqcGdeQXVyNDYyMDk5MTU@._V1_SX300.jpg\",\n" +
            "            \"Ratings\":[  \n" +
            "                {  \n" +
            "                    \"Source\":\"Internet Movie Database\",\n" +
            "                    \"Value\":\"8.8/10\"\n" +
            "                },\n" +
            "                {  \n" +
            "                    \"Source\":\"Rotten Tomatoes\",\n" +
            "                    \"Value\":\"94%\"\n" +
            "                },\n" +
            "                {  \n" +
            "                    \"Source\":\"Metacritic\",\n" +
            "                    \"Value\":\"81/100\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"Metascore\":\"81\",\n" +
            "            \"imdbRating\":\"8.8\",\n" +
            "            \"imdbVotes\":\"890,313\",\n" +
            "            \"imdbID\":\"tt0080684\",\n" +
            "            \"Type\":\"movie\",\n" +
            "            \"DVD\":\"21 Sep 2004\",\n" +
            "            \"BoxOffice\":\"$4,548,170.00\",\n" +
            "            \"Production\":\"Twentieth Century Fox\",\n" +
            "            \"Website\":\"http://www.starwars.com/episode-v/\",\n" +
            "            \"Response\":\"True\"\n" +
            "        },\n" +
            "        {  \n" +
            "            \"Title\":\"Inception\",\n" +
            "            \"Year\":\"2010\",\n" +
            "            \"Rated\":\"PG-13\",\n" +
            "            \"Released\":\"16 Jul 2010\",\n" +
            "            \"Runtime\":\"148 min\",\n" +
            "            \"Genre\":\"Action, Adventure, Sci-Fi\",\n" +
            "            \"Director\":\"Christopher Nolan\",\n" +
            "            \"Writer\":\"Christopher Nolan\",\n" +
            "            \"Actors\":\"Leonardo DiCaprio, Joseph Gordon-Levitt, Ellen Page, Tom Hardy\",\n" +
            "            \"Plot\":\"Dom Cobb is a skilled thief, the absolute best in the dangerous art of extraction, stealing valuable secrets from deep within the subconscious during the dream state, when the mind is at its most vulnerable. Cobb's rare ability has made him a coveted player in this treacherous new world of corporate espionage, but it has also made him an international fugitive and cost him everything he has ever loved. Now Cobb is being offered a chance at redemption. One last job could give him his life back but only if he can accomplish the impossible - inception. Instead of the perfect heist, Cobb and his team of specialists have to pull off the reverse: their task is not to steal an idea but to plant one. If they succeed, it could be the perfect crime. But no amount of careful planning or expertise can prepare the team for the dangerous enemy that seems to predict their every move. An enemy that only Cobb could have seen coming.\",\n" +
            "            \"Language\":\"English, Japanese, French\",\n" +
            "            \"Country\":\"USA, UK\",\n" +
            "            \"Awards\":\"Won 4 Oscars. Another 145 wins & 197 nominations.\",\n" +
            "            \"Poster\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_SX300.jpg\",\n" +
            "            \"Ratings\":[  \n" +
            "                {  \n" +
            "                    \"Source\":\"Internet Movie Database\",\n" +
            "                    \"Value\":\"8.8/10\"\n" +
            "                },\n" +
            "                {  \n" +
            "                    \"Source\":\"Rotten Tomatoes\",\n" +
            "                    \"Value\":\"86%\"\n" +
            "                },\n" +
            "                {  \n" +
            "                    \"Source\":\"Metacritic\",\n" +
            "                    \"Value\":\"74/100\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"Metascore\":\"74\",\n" +
            "            \"imdbRating\":\"8.8\",\n" +
            "            \"imdbVotes\":\"1,557,867\",\n" +
            "            \"imdbID\":\"tt1375666\",\n" +
            "            \"Type\":\"movie\",\n" +
            "            \"DVD\":\"07 Dec 2010\",\n" +
            "            \"BoxOffice\":\"$292,568,851.00\",\n" +
            "            \"Production\":\"Warner Bros. Pictures\",\n" +
            "            \"Website\":\"http://inceptionmovie.warnerbros.com/\",\n" +
            "            \"Response\":\"True\"\n" +
            "        },\n" +
            "        {  \n" +
            "            \"Title\":\"The Matrix\",\n" +
            "            \"Year\":\"1999\",\n" +
            "            \"Rated\":\"R\",\n" +
            "            \"Released\":\"31 Mar 1999\",\n" +
            "            \"Runtime\":\"136 min\",\n" +
            "            \"Genre\":\"Action, Sci-Fi\",\n" +
            "            \"Director\":\"Lana Wachowski, Lilly Wachowski\",\n" +
            "            \"Writer\":\"Lilly Wachowski, Lana Wachowski\",\n" +
            "            \"Actors\":\"Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss, Hugo Weaving\",\n" +
            "            \"Plot\":\"Thomas A. Anderson is a man living two lives. By day he is an average computer programmer and by night a hacker known as Neo. Neo has always questioned his reality, but the truth is far beyond his imagination. Neo finds himself targeted by the police when he is contacted by Morpheus, a legendary computer hacker branded a terrorist by the government. Morpheus awakens Neo to the real world, a ravaged wasteland where most of humanity have been captured by a race of machines that live off of the humans' body heat and electrochemical energy and who imprison their minds within an artificial reality known as the Matrix. As a rebel against the machines, Neo must return to the Matrix and confront the agents: super-powerful computer programs devoted to snuffing out Neo and the entire human rebellion.\",\n" +
            "            \"Language\":\"English\",\n" +
            "            \"Country\":\"USA\",\n" +
            "            \"Awards\":\"Won 4 Oscars. Another 33 wins & 45 nominations.\",\n" +
            "            \"Poster\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BNzQzOTk3OTAtNDQ0Zi00ZTVkLWI0MTEtMDllZjNkYzNjNTc4L2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SX300.jpg\",\n" +
            "            \"Ratings\":[  \n" +
            "                {  \n" +
            "                    \"Source\":\"Internet Movie Database\",\n" +
            "                    \"Value\":\"8.7/10\"\n" +
            "                },\n" +
            "                {  \n" +
            "                    \"Source\":\"Rotten Tomatoes\",\n" +
            "                    \"Value\":\"87%\"\n" +
            "                },\n" +
            "                {  \n" +
            "                    \"Source\":\"Metacritic\",\n" +
            "                    \"Value\":\"73/100\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"Metascore\":\"73\",\n" +
            "            \"imdbRating\":\"8.7\",\n" +
            "            \"imdbVotes\":\"1,289,137\",\n" +
            "            \"imdbID\":\"tt0133093\",\n" +
            "            \"Type\":\"movie\",\n" +
            "            \"DVD\":\"21 Sep 1999\",\n" +
            "            \"BoxOffice\":\"N/A\",\n" +
            "            \"Production\":\"Warner Bros. Pictures\",\n" +
            "            \"Website\":\"http://www.whatisthematrix.com\",\n" +
            "            \"Response\":\"True\"\n" +
            "        },\n" +
            "        {  \n" +
            "            \"Title\":\"Seven Samurai\",\n" +
            "            \"Year\":\"1954\",\n" +
            "            \"Rated\":\"UNRATED\",\n" +
            "            \"Released\":\"19 Nov 1956\",\n" +
            "            \"Runtime\":\"207 min\",\n" +
            "            \"Genre\":\"Adventure, Drama\",\n" +
            "            \"Director\":\"Akira Kurosawa\",\n" +
            "            \"Writer\":\"Akira Kurosawa (screenplay), Shinobu Hashimoto (screenplay), Hideo Oguni (screenplay)\",\n" +
            "            \"Actors\":\"Toshirô Mifune, Takashi Shimura, Keiko Tsushima, Yukiko Shimazaki\",\n" +
            "            \"Plot\":\"A veteran samurai, who has fallen on hard times, answers a village's request for protection from bandits. He gathers 6 other samurai to help him, and they teach the townspeople how to defend themselves, and they supply the samurai with three small meals a day. The film culminates in a giant battle when 40 bandits attack the village.\",\n" +
            "            \"Language\":\"Japanese\",\n" +
            "            \"Country\":\"Japan\",\n" +
            "            \"Awards\":\"Nominated for 2 Oscars. Another 5 wins & 6 nominations.\",\n" +
            "            \"Poster\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BMTc5MDY1MjU5MF5BMl5BanBnXkFtZTgwNDM2OTE4MzE@._V1_SX300.jpg\",\n" +
            "            \"Ratings\":[  \n" +
            "                {  \n" +
            "                    \"Source\":\"Internet Movie Database\",\n" +
            "                    \"Value\":\"8.7/10\"\n" +
            "                },\n" +
            "                {  \n" +
            "                    \"Source\":\"Rotten Tomatoes\",\n" +
            "                    \"Value\":\"100%\"\n" +
            "                },\n" +
            "                {  \n" +
            "                    \"Source\":\"Metacritic\",\n" +
            "                    \"Value\":\"98/100\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"Metascore\":\"98\",\n" +
            "            \"imdbRating\":\"8.7\",\n" +
            "            \"imdbVotes\":\"241,844\",\n" +
            "            \"imdbID\":\"tt0047478\",\n" +
            "            \"Type\":\"movie\",\n" +
            "            \"DVD\":\"01 Mar 1999\",\n" +
            "            \"BoxOffice\":\"N/A\",\n" +
            "            \"Production\":\"Columbia Pictures\",\n" +
            "            \"Website\":\"N/A\",\n" +
            "            \"Response\":\"True\"\n" +
            "        },\n" +
            "        {  \n" +
            "            \"Title\":\"City of God\",\n" +
            "            \"Year\":\"2002\",\n" +
            "            \"Rated\":\"R\",\n" +
            "            \"Released\":\"13 Feb 2004\",\n" +
            "            \"Runtime\":\"130 min\",\n" +
            "            \"Genre\":\"Crime, Drama\",\n" +
            "            \"Director\":\"Fernando Meirelles, Kátia Lund\",\n" +
            "            \"Writer\":\"Paulo Lins (novel), Bráulio Mantovani (screenplay)\",\n" +
            "            \"Actors\":\"Alexandre Rodrigues, Leandro Firmino, Phellipe Haagensen, Douglas Silva\",\n" +
            "            \"Plot\":\"Brazil, 1960s, City of God. The Tender Trio robs motels and gas trucks. Younger kids watch and learn well...too well. 1970s: Li'l Zé has prospered very well and owns the city. He causes violence and fear as he wipes out rival gangs without mercy. His best friend Bené is the only one to keep him on the good side of sanity. Rocket has watched these two gain power for years, and he wants no part of it. Yet he keeps getting swept up in the madness. All he wants to do is take pictures. 1980s: Things are out of control between the last two remaining gangs...will it ever end? Welcome to the City of God.\",\n" +
            "            \"Language\":\"Portuguese\",\n" +
            "            \"Country\":\"Brazil, France\",\n" +
            "            \"Awards\":\"Nominated for 4 Oscars. Another 65 wins & 38 nominations.\",\n" +
            "            \"Poster\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BMjA4ODQ3ODkzNV5BMl5BanBnXkFtZTYwOTc4NDI3._V1_SX300.jpg\",\n" +
            "            \"Ratings\":[  \n" +
            "                {  \n" +
            "                    \"Source\":\"Internet Movie Database\",\n" +
            "                    \"Value\":\"8.7/10\"\n" +
            "                },\n" +
            "                {  \n" +
            "                    \"Source\":\"Rotten Tomatoes\",\n" +
            "                    \"Value\":\"90%\"\n" +
            "                },\n" +
            "                {  \n" +
            "                    \"Source\":\"Metacritic\",\n" +
            "                    \"Value\":\"79/100\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"Metascore\":\"79\",\n" +
            "            \"imdbRating\":\"8.7\",\n" +
            "            \"imdbVotes\":\"561,567\",\n" +
            "            \"imdbID\":\"tt0317248\",\n" +
            "            \"Type\":\"movie\",\n" +
            "            \"DVD\":\"08 Jun 2004\",\n" +
            "            \"BoxOffice\":\"N/A\",\n" +
            "            \"Production\":\"Miramax Films\",\n" +
            "            \"Website\":\"http://www.miramax.com/movie/city-of-god\",\n" +
            "            \"Response\":\"True\"\n" +
            "        },\n" +
            "        {  \n" +
            "            \"Title\":\"Se7en\",\n" +
            "            \"Year\":\"1995\",\n" +
            "            \"Rated\":\"R\",\n" +
            "            \"Released\":\"22 Sep 1995\",\n" +
            "            \"Runtime\":\"127 min\",\n" +
            "            \"Genre\":\"Crime, Drama, Mystery\",\n" +
            "            \"Director\":\"David Fincher\",\n" +
            "            \"Writer\":\"Andrew Kevin Walker\",\n" +
            "            \"Actors\":\"Morgan Freeman, Andrew Kevin Walker, Kevin Spacey, Daniel Zacapa\",\n" +
            "            \"Plot\":\"A film about two homicide detectives' (Morgan Freeman and (Brad Pitt desperate hunt for a serial killer who justifies his crimes as absolution for the world's ignorance of the Seven Deadly Sins. The movie takes us from the tortured remains of one victim to the next as the sociopathic \\\"John Doe\\\" (Kevin Spacey) sermonizes to Detectives Somerset and Mills -- one sin at a time. The sin of Gluttony comes first and the murderer's terrible capacity is graphically demonstrated in the dark and subdued tones characteristic of film noir. The seasoned and cultured but jaded Somerset researches the Seven Deadly Sins in an effort to understand the killer's modus operandi while the bright but green and impulsive Detective Mills (Pitt) scoffs at his efforts to get inside the mind of a killer...\",\n" +
            "            \"Language\":\"English\",\n" +
            "            \"Country\":\"USA\",\n" +
            "            \"Awards\":\"Nominated for 1 Oscar. Another 25 wins & 34 nominations.\",\n" +
            "            \"Poster\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BOTUwODM5MTctZjczMi00OTk4LTg3NWUtNmVhMTAzNTNjYjcyXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SX300.jpg\",\n" +
            "            \"Ratings\":[  \n" +
            "                {  \n" +
            "                    \"Source\":\"Internet Movie Database\",\n" +
            "                    \"Value\":\"8.6/10\"\n" +
            "                },\n" +
            "                {  \n" +
            "                    \"Source\":\"Rotten Tomatoes\",\n" +
            "                    \"Value\":\"80%\"\n" +
            "                },\n" +
            "                {  \n" +
            "                    \"Source\":\"Metacritic\",\n" +
            "                    \"Value\":\"65/100\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"Metascore\":\"65\",\n" +
            "            \"imdbRating\":\"8.6\",\n" +
            "            \"imdbVotes\":\"1,081,965\",\n" +
            "            \"imdbID\":\"tt0114369\",\n" +
            "            \"Type\":\"movie\",\n" +
            "            \"DVD\":\"14 Apr 1997\",\n" +
            "            \"BoxOffice\":\"N/A\",\n" +
            "            \"Production\":\"New Line Cinema\",\n" +
            "            \"Website\":\"N/A\",\n" +
            "            \"Response\":\"True\"\n" +
            "        },\n" +
            "        {  \n" +
            "            \"Title\":\"Life Is Beautiful\",\n" +
            "            \"Year\":\"1997\",\n" +
            "            \"Rated\":\"PG-13\",\n" +
            "            \"Released\":\"12 Feb 1999\",\n" +
            "            \"Runtime\":\"116 min\",\n" +
            "            \"Genre\":\"Comedy, Drama, War\",\n" +
            "            \"Director\":\"Roberto Benigni\",\n" +
            "            \"Writer\":\"Vincenzo Cerami (story and screenplay by), Roberto Benigni (story and screenplay by)\",\n" +
            "            \"Actors\":\"Roberto Benigni, Nicoletta Braschi, Giorgio Cantarini, Giustino Durano\",\n" +
            "            \"Plot\":\"In 1930s Italy, a carefree Jewish book keeper named Guido starts a fairy tale life by courting and marrying a lovely woman from a nearby city. Guido and his wife have a son and live happily together until the occupation of Italy by German forces. In an attempt to hold his family together and help his son survive the horrors of a Jewish Concentration Camp, Guido imagines that the Holocaust is a game and that the grand prize for winning is a tank.\",\n" +
            "            \"Language\":\"Italian, German, English\",\n" +
            "            \"Country\":\"Italy\",\n" +
            "            \"Awards\":\"Won 3 Oscars. Another 66 wins & 51 nominations.\",\n" +
            "            \"Poster\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BYmJmM2Q4NmMtYThmNC00ZjRlLWEyZmItZTIwOTBlZDQ3NTQ1XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg\",\n" +
            "            \"Ratings\":[  \n" +
            "                {  \n" +
            "                    \"Source\":\"Internet Movie Database\",\n" +
            "                    \"Value\":\"8.6/10\"\n" +
            "                },\n" +
            "                {  \n" +
            "                    \"Source\":\"Rotten Tomatoes\",\n" +
            "                    \"Value\":\"80%\"\n" +
            "                },\n" +
            "                {  \n" +
            "                    \"Source\":\"Metacritic\",\n" +
            "                    \"Value\":\"59/100\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"Metascore\":\"59\",\n" +
            "            \"imdbRating\":\"8.6\",\n" +
            "            \"imdbVotes\":\"452,956\",\n" +
            "            \"imdbID\":\"tt0118799\",\n" +
            "            \"Type\":\"movie\",\n" +
            "            \"DVD\":\"09 Nov 1999\",\n" +
            "            \"BoxOffice\":\"N/A\",\n" +
            "            \"Production\":\"Miramax\",\n" +
            "            \"Website\":\"http://www.miramax.com/movie/life-is-beautiful/\",\n" +
            "            \"Response\":\"True\"\n" +
            "        },\n" +
            "        {  \n" +
            "            \"Title\":\"Interstellar\",\n" +
            "            \"Year\":\"2014\",\n" +
            "            \"Rated\":\"PG-13\",\n" +
            "            \"Released\":\"07 Nov 2014\",\n" +
            "            \"Runtime\":\"169 min\",\n" +
            "            \"Genre\":\"Adventure, Drama, Sci-Fi\",\n" +
            "            \"Director\":\"Christopher Nolan\",\n" +
            "            \"Writer\":\"Jonathan Nolan, Christopher Nolan\",\n" +
            "            \"Actors\":\"Ellen Burstyn, Matthew McConaughey, Mackenzie Foy, John Lithgow\",\n" +
            "            \"Plot\":\"A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.\",\n" +
            "            \"Language\":\"English\",\n" +
            "            \"Country\":\"USA, UK, Canada, Iceland\",\n" +
            "            \"Awards\":\"Won 1 Oscar. Another 41 wins & 141 nominations.\",\n" +
            "            \"Poster\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BMjIxNTU4MzY4MF5BMl5BanBnXkFtZTgwMzM4ODI3MjE@._V1_SX300.jpg\",\n" +
            "            \"Ratings\":[  \n" +
            "                {  \n" +
            "                    \"Source\":\"Internet Movie Database\",\n" +
            "                    \"Value\":\"8.6/10\"\n" +
            "                },\n" +
            "                {  \n" +
            "                    \"Source\":\"Rotten Tomatoes\",\n" +
            "                    \"Value\":\"71%\"\n" +
            "                },\n" +
            "                {  \n" +
            "                    \"Source\":\"Metacritic\",\n" +
            "                    \"Value\":\"74/100\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"Metascore\":\"74\",\n" +
            "            \"imdbRating\":\"8.6\",\n" +
            "            \"imdbVotes\":\"1,023,236\",\n" +
            "            \"imdbID\":\"tt0816692\",\n" +
            "            \"Type\":\"movie\",\n" +
            "            \"DVD\":\"31 Mar 2015\",\n" +
            "            \"BoxOffice\":\"$158,737,441.00\",\n" +
            "            \"Production\":\"Paramount Pictures\",\n" +
            "            \"Website\":\"http://www.InterstellarMovie.com/\",\n" +
            "            \"Response\":\"True\"\n" +
            "        },\n" +
            "        {  \n" +
            "            \"Title\":\"Whiplash\",\n" +
            "            \"Year\":\"2014\",\n" +
            "            \"Rated\":\"R\",\n" +
            "            \"Released\":\"15 Oct 2014\",\n" +
            "            \"Runtime\":\"107 min\",\n" +
            "            \"Genre\":\"Drama, Music\",\n" +
            "            \"Director\":\"Damien Chazelle\",\n" +
            "            \"Writer\":\"Damien Chazelle\",\n" +
            "            \"Actors\":\"Miles Teller, J.K. Simmons, Paul Reiser, Melissa Benoist\",\n" +
            "            \"Plot\":\"A young and talented drummer attending a prestigious music academy finds himself under the wing of the most respected professor at the school, one who does not hold back on abuse towards his students. The two form an odd relationship as the student wants to achieve greatness, and the professor pushes him.\",\n" +
            "            \"Language\":\"English\",\n" +
            "            \"Country\":\"USA\",\n" +
            "            \"Awards\":\"Won 3 Oscars. Another 89 wins & 135 nominations.\",\n" +
            "            \"Poster\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BOTVhMWQ5MDktMGE3OS00MjVlLWExZWYtMzY2MTg4ZGFiZDQ5L2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SX300.jpg\",\n" +
            "            \"Ratings\":[  \n" +
            "                {  \n" +
            "                    \"Source\":\"Internet Movie Database\",\n" +
            "                    \"Value\":\"8.5/10\"\n" +
            "                },\n" +
            "                {  \n" +
            "                    \"Source\":\"Rotten Tomatoes\",\n" +
            "                    \"Value\":\"94%\"\n" +
            "                },\n" +
            "                {  \n" +
            "                    \"Source\":\"Metacritic\",\n" +
            "                    \"Value\":\"88/100\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"Metascore\":\"88\",\n" +
            "            \"imdbRating\":\"8.5\",\n" +
            "            \"imdbVotes\":\"465,691\",\n" +
            "            \"imdbID\":\"tt2582802\",\n" +
            "            \"Type\":\"movie\",\n" +
            "            \"DVD\":\"24 Feb 2015\",\n" +
            "            \"BoxOffice\":\"N/A\",\n" +
            "            \"Production\":\"Sony Pictures Classics\",\n" +
            "            \"Website\":\"http://sonyclassics.com/whiplash/\",\n" +
            "            \"Response\":\"True\"\n" +
            "        },\n" +
            "        {  \n" +
            "            \"Title\":\"Django Unchained\",\n" +
            "            \"Year\":\"2012\",\n" +
            "            \"Rated\":\"R\",\n" +
            "            \"Released\":\"25 Dec 2012\",\n" +
            "            \"Runtime\":\"165 min\",\n" +
            "            \"Genre\":\"Drama, Western\",\n" +
            "            \"Director\":\"Quentin Tarantino\",\n" +
            "            \"Writer\":\"Quentin Tarantino\",\n" +
            "            \"Actors\":\"Jamie Foxx, Christoph Waltz, Leonardo DiCaprio, Kerry Washington\",\n" +
            "            \"Plot\":\"A German dentist buys the freedom of a slave and trains him with the intent to make him his deputy bounty hunter. Instead, he is led to the site of the slave's wife who belongs to a ruthless plantation owner.\",\n" +
            "            \"Language\":\"English, German, French, Italian\",\n" +
            "            \"Country\":\"USA\",\n" +
            "            \"Awards\":\"Won 2 Oscars. Another 54 wins & 144 nominations.\",\n" +
            "            \"Poster\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BMjIyNTQ5NjQ1OV5BMl5BanBnXkFtZTcwODg1MDU4OA@@._V1_SX300.jpg\",\n" +
            "            \"Ratings\":[  \n" +
            "                {  \n" +
            "                    \"Source\":\"Internet Movie Database\",\n" +
            "                    \"Value\":\"8.4/10\"\n" +
            "                },\n" +
            "                {  \n" +
            "                    \"Source\":\"Rotten Tomatoes\",\n" +
            "                    \"Value\":\"88%\"\n" +
            "                },\n" +
            "                {  \n" +
            "                    \"Source\":\"Metacritic\",\n" +
            "                    \"Value\":\"81/100\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"Metascore\":\"81\",\n" +
            "            \"imdbRating\":\"8.4\",\n" +
            "            \"imdbVotes\":\"1,024,786\",\n" +
            "            \"imdbID\":\"tt1853728\",\n" +
            "            \"Type\":\"movie\",\n" +
            "            \"DVD\":\"16 Apr 2013\",\n" +
            "            \"BoxOffice\":\"$162,804,648.00\",\n" +
            "            \"Production\":\"The Weinstein Co.\",\n" +
            "            \"Website\":\"http://unchainedmovie.com/\",\n" +
            "            \"Response\":\"True\"\n" +
            "        },\n" +
            "        {  \n" +
            "            \"Title\":\"WALL·E\",\n" +
            "            \"Year\":\"2008\",\n" +
            "            \"Rated\":\"G\",\n" +
            "            \"Released\":\"27 Jun 2008\",\n" +
            "            \"Runtime\":\"98 min\",\n" +
            "            \"Genre\":\"Animation, Adventure, Family\",\n" +
            "            \"Director\":\"Andrew Stanton\",\n" +
            "            \"Writer\":\"Andrew Stanton (original story by), Pete Docter (original story by), Andrew Stanton (screenplay), Jim Reardon (screenplay)\",\n" +
            "            \"Actors\":\"Ben Burtt, Elissa Knight, Jeff Garlin, Fred Willard\",\n" +
            "            \"Plot\":\"In the distant future, a small waste-collecting robot inadvertently embarks on a space journey that will ultimately decide the fate of mankind.\",\n" +
            "            \"Language\":\"English\",\n" +
            "            \"Country\":\"USA\",\n" +
            "            \"Awards\":\"Won 1 Oscar. Another 87 wins & 85 nominations.\",\n" +
            "            \"Poster\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BMjExMTg5OTU0NF5BMl5BanBnXkFtZTcwMjMxMzMzMw@@._V1_SX300.jpg\",\n" +
            "            \"Ratings\":[  \n" +
            "                {  \n" +
            "                    \"Source\":\"Internet Movie Database\",\n" +
            "                    \"Value\":\"8.4/10\"\n" +
            "                },\n" +
            "                {  \n" +
            "                    \"Source\":\"Rotten Tomatoes\",\n" +
            "                    \"Value\":\"96%\"\n" +
            "                },\n" +
            "                {  \n" +
            "                    \"Source\":\"Metacritic\",\n" +
            "                    \"Value\":\"94/100\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"Metascore\":\"94\",\n" +
            "            \"imdbRating\":\"8.4\",\n" +
            "            \"imdbVotes\":\"765,781\",\n" +
            "            \"imdbID\":\"tt0910970\",\n" +
            "            \"Type\":\"movie\",\n" +
            "            \"DVD\":\"18 Nov 2008\",\n" +
            "            \"BoxOffice\":\"$223,749,872.00\",\n" +
            "            \"Production\":\"Walt Disney Pictures\",\n" +
            "            \"Website\":\"http://www.wall-e.com/\",\n" +
            "            \"Response\":\"True\"\n" +
            "        },\n" +
            "        {  \n" +
            "            \"Title\":\"Logan\",\n" +
            "            \"Year\":\"2017\",\n" +
            "            \"Rated\":\"R\",\n" +
            "            \"Released\":\"03 Mar 2017\",\n" +
            "            \"Runtime\":\"137 min\",\n" +
            "            \"Genre\":\"Action, Drama, Sci-Fi\",\n" +
            "            \"Director\":\"James Mangold\",\n" +
            "            \"Writer\":\"James Mangold (story by), Scott Frank (screenplay), James Mangold (screenplay), Michael Green (screenplay)\",\n" +
            "            \"Actors\":\"Hugh Jackman, Patrick Stewart, Dafne Keen, Boyd Holbrook\",\n" +
            "            \"Plot\":\"In 2029 the mutant population has shrunk significantly and the X-Men have disbanded. Logan, whose power to self-heal is dwindling, has surrendered himself to alcohol and now earns a living as a chauffeur. He takes care of the ailing old Professor X whom he keeps hidden away. One day, a female stranger asks Logan to drive a girl named Laura to the Canadian border. At first he refuses, but the Professor has been waiting for a long time for her to appear. Laura possesses an extraordinary fighting prowess and is in many ways like Wolverine. She is pursued by sinister figures working for a powerful corporation; this is because her DNA contains the secret that connects her to Logan. A relentless pursuit begins - In this third cinematic outing featuring the Marvel comic book character Wolverine we see the superheroes beset by everyday problems. They are ageing, ailing and struggling to survive financially. A decrepit Logan is forced to ask himself if he can or even wants to put his remaining powers to good use. It would appear that in the near-future, the times in which they were able put the world to rights with razor sharp claws and telepathic powers are now over.\",\n" +
            "            \"Language\":\"English, Spanish\",\n" +
            "            \"Country\":\"USA\",\n" +
            "            \"Awards\":\"N/A\",\n" +
            "            \"Poster\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BMjI1MjkzMjczMV5BMl5BanBnXkFtZTgwNDk4NjYyMTI@._V1_SX300.jpg\",\n" +
            "            \"Ratings\":[  \n" +
            "                {  \n" +
            "                    \"Source\":\"Internet Movie Database\",\n" +
            "                    \"Value\":\"8.5/10\"\n" +
            "                },\n" +
            "                {  \n" +
            "                    \"Source\":\"Rotten Tomatoes\",\n" +
            "                    \"Value\":\"93%\"\n" +
            "                },\n" +
            "                {  \n" +
            "                    \"Source\":\"Metacritic\",\n" +
            "                    \"Value\":\"77/100\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"Metascore\":\"77\",\n" +
            "            \"imdbRating\":\"8.5\",\n" +
            "            \"imdbVotes\":\"181,361\",\n" +
            "            \"imdbID\":\"tt3315342\",\n" +
            "            \"Type\":\"movie\",\n" +
            "            \"DVD\":\"N/A\",\n" +
            "            \"BoxOffice\":\"N/A\",\n" +
            "            \"Production\":\"20th Century Fox\",\n" +
            "            \"Website\":\"http://www.foxmovies.com/movies/logan\",\n" +
            "            \"Response\":\"True\"\n" +
            "        }\n" +
            "    ]\n" +
            "} ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        data = new ArrayList<>();

        try {
            JSONObject object = new JSONObject(json);
            JSONArray movies = object.getJSONArray("movies");

            for (int i=0;i<movies.length();i++){
                JSONObject main = movies.getJSONObject(i);

                HashMap<String, String> map = new HashMap<>();

                map.put("title", main.getString("Title"));
                map.put("release", main.getString("Released"));
                map.put("director", main.getString("Director"));
                map.put("cast", main.getString("Actors"));
                map.put("genre", main.getString("Genre"));
                map.put("language", main.getString("Language"));
                map.put("plot", main.getString("Plot"));
                map.put("poster", main.getString("Poster"));
                map.put("rating", main.getString("imdbRating"));

                data.add(map);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        ListView lv = (ListView) findViewById(R.id.list_view);

        CustomListAdapter adapter = new CustomListAdapter(this, data);
        lv.setAdapter(adapter);

        //Implemented OnClickListener on List Items.

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HashMap<String, String> map = data.get(position);

                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("title", map.get("title"));             //added data to pass to the new activity
                intent.putExtra("release", map.get("release"));
                intent.putExtra("director", map.get("director"));
                intent.putExtra("cast", map.get("cast"));
                intent.putExtra("genre", map.get("genre"));
                intent.putExtra("language", map.get("language"));
                intent.putExtra("plot", map.get("plot"));
                intent.putExtra("poster", map.get("poster"));
                intent.putExtra("rating", map.get("rating"));
                startActivity(intent);
            }
        });
    }

    class CustomListAdapter extends BaseAdapter {

        Context context;
        int id;
        ArrayList<HashMap<String, String>> list;

        public CustomListAdapter(Context cxt, ArrayList<HashMap<String,
                 String>> data) {
            context = cxt;
            list = data;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            convertView = LayoutInflater.from(context).inflate(R.layout.movie_items
            ,parent, false);

            ImageView poster = (ImageView) convertView.findViewById(R.id.poster);

            TextView title = (TextView) convertView.findViewById(R.id.title);
            TextView director = (TextView) convertView.findViewById(R.id.director);
            TextView cast = (TextView) convertView.findViewById(R.id.cast);
            TextView rating = (TextView) convertView.findViewById(R.id.rating);

            HashMap<String, String> map = list.get(position);

            title.setText(map.get("title"));
            director.setText(map.get("director"));
            cast.setText(map.get("cast"));
            rating.setText(map.get("rating"));

            // Refer DetailActivity for more detail on Picasso.
            Picasso.with(context)
                    .load(map.get("poster"))
                    .into(poster);

            return convertView;
        }
    }
}
