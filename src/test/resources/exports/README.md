no-week-provided.json -> http://football.myfantasyleague.com/2015/export?TYPE=nflSchedule&L=&W=&JSON=1
not-started-week.json -> http://football.myfantasyleague.com/2015/export?TYPE=nflSchedule&L=&W=1&JSON=1
completed-week.json   -> http://football.myfantasyleague.com/2014/export?TYPE=nflSchedule&L=&W=1&JSON=1 ( note previous year )


playerStatus/invalid-request.json -> http://football7.myfantasyleague.com/2015/export?TYPE=playerStatus&L=71210&W=&JSON=1 ( no ID given )
playerStatus/player-status.json -> http://football16.myfantasyleague.com/2015/export?TYPE=playerStatus&L=12106&P=8658,11192,10998,99999&JSON=1 ( combo of FA, rostered, and bogus ID ... need an example of "locked" player )
playerStatus/single-player.json -> http://football16.myfantasyleague.com/2015/export?TYPE=playerStatus&L=12106&P=11192&JSON=1