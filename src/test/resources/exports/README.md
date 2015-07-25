no-week-provided.json -> http://football.myfantasyleague.com/2015/export?TYPE=nflSchedule&L=&W=&JSON=1
not-started-week.json -> http://football.myfantasyleague.com/2015/export?TYPE=nflSchedule&L=&W=1&JSON=1
completed-week.json   -> http://football.myfantasyleague.com/2014/export?TYPE=nflSchedule&L=&W=1&JSON=1 ( note previous year )


playerStatus/invalid-request.json -> http://football7.myfantasyleague.com/2015/export?TYPE=playerStatus&L=71210&W=&JSON=1 ( no ID given )
playerStatus/player-status.json -> http://football16.myfantasyleague.com/2015/export?TYPE=playerStatus&L=12106&P=8658,11192,10998,99999&JSON=1 ( combo of FA, rostered, and bogus ID ... need an example of "locked" player )
playerStatus/single-player.json -> http://football16.myfantasyleague.com/2015/export?TYPE=playerStatus&L=12106&P=11192&JSON=1

injuries/invalid-week.json -> http://football.myfantasyleague.com/2015/export?TYPE=injuries&L=&W=23&JSON=1
injuries/injuries.json -> http://football.myfantasyleague.com/2015/export?TYPE=injuries&L=&W=&JSON=1

* playerScores/full-schedule.json -> http://football16.myfantasyleague.com/2014/export?TYPE=playerScores&L=71210&PLAYERS=10695&JSON=1
* playerScores/week-without-scoring.json -> http://football16.myfantasyleague.com/2014/export?TYPE=playerScores&L=71210&PLAYERS=9925&JSON=1 ( poor jimmy didn't register a catch weeks 7, 13 )
* playerScores/injured-player.json -> http://football16.myfantasyleague.com/2014/export?TYPE=playerScores&L=71210&PLAYERS=9690&JSON=1 ( arian was out weeks 3, 11, 12 )
* playerScores/suspended-player.json -> http://football16.myfantasyleague.com/2014/export?TYPE=playerScores&L=71210&PLAYERS=10274&JSON=1 ( oh aldon, you bad boy )

* playerScores/multi-player-average.json -> http://football16.myfantasyleague.com/2014/export?TYPE=playerScores&L=71210&PLAYERS=10695,11192&W=AVG&JSON=1
* playerScores/multi-player-year-to-date.json -> http://football16.myfantasyleague.com/2014/export?TYPE=playerScores&L=71210&PLAYERS=10695,11192&W=YTD&JSON=1
* playerScores/multi-player-average-before-season-starts.json - http://football7.myfantasyleague.com/2015/export?TYPE=playerScores&L=71210&PLAYERS=10695,11192&W=AVG&JSON=1
* playerScores/multi-player-year-to-date-before-season-starts.json - http://football7.myfantasyleague.com/201**5**/export?TYPE=playerScores&L=71210&PLAYERS=10695,11192&W=YTD&JSON=1

* players/player-updates-with-timestamp.json -> http://football.myfantasyleague.com/2015/export?TYPE=players&SINCE=1437000000&JSON=1  ( export taken 7/25/2015 )
* players/player-updates-with-timestamp-error.json -> http://football.myfantasyleague.com/2015/export?TYPE=players&SINCE=3489000000&JSON=1
