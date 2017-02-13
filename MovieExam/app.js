
/**
 * Module dependencies.
 */

var express = require('express')
  , routes = require('./routes')
  , user = require('./routes/user')
  , http = require('http')
  , path = require('path');

var app = express();

// all environments
app.set('port', process.env.PORT || 3000);
app.set('views', __dirname + '/views');
app.set('view engine', 'jade');
app.use(express.favicon());
app.use(express.logger('dev'));
app.use(express.bodyParser());
app.use(express.methodOverride());
app.use(app.router);
app.use(express.static(path.join(__dirname, 'public')));

// development only
if ('development' == app.get('env')) {
  app.use(express.errorHandler());
}

//mysql 서버연결//////////////////////////////////////////////
var mysql      = require('mysql');
var connection = mysql.createConnection({
  host     : 'localhost',
  user     : 'root',
  password : '1234',
  database : 'movieapi'
});
connection.connect();	

//mongodb 서버연결//////////////////////////////////////////////
var MongoClient = require('mongodb').MongoClient;
//Connection URL 
var url = 'mongodb://localhost:27017/didimdol';
//Use connect method to connect to the Server 
var dbObj = null;
MongoClient.connect(url, function(err, db) {
	console.log("Connected correctly to server");
	dbObj = db;
	//db.close();
});
//////////////////////////////////////////////////////

app.get('/', function(req, res){
	connection.query('SELECT * from movie', function (error, results, fields) {
		  if (error) res.send(error);
		  else {
			  var movie = dbObj.collection('movie');
			  movie.find({}).toArray(function(error, docs){//MongoDB 조회쿼리
				  if(error) res.send(error);
				  else{ //APPLICATION SIDE JOIN---------------------------
					  for (var i = 0; i < results.length; i++){
						  for(var j = 0; j < docs.length; j++){
							  if(results[i].no == docs[j].no){
								  results[i].review = docs[j].review;
								  break;
							  }
						  }
					  }
					  res.send(JSON.stringify(results));
				  }	
			  });
		  }
		//connection.end();
	});
});
app.get('/movie', function(req, res){
	connection.query('SELECT * from movie WHERE no=?', req.query.no, 
			function (error, results, fields) {
		  if (error) res.send(error);
		  else res.send(JSON.stringify(results));
		});
		 
		//connection.end();
});
app.post('/', function(req, res){ 
	console.log(req.body.watchingRate);
	var obj = {
			no:Number(req.body.no),
			category:Number(req.body.category),
			title:req.body.title,
			playdate:req.body.playdate/*,
			runningtime:Number(req.body.runningtime)/*,
			watchingRate:1//Number(req.body.watchingRate),
			/*nation:req.body.nation,
			totalAudience:Number(req.body.totalAudience),
			reviewPoint:Number(req.body.reviewPoint),
			actor:req.body.actor*/
		};
	console.log(obj);
	connection.query('INSERT INTO movie SET ?', 
			obj,
			function (error, result) {
		  if (error) res.send(error);
		  else{
			  if (req.body.review != undefined){
				  var movie = dbObj.collection('movie');
				  moive.save(
					{
					 
					  revie:req.body.review
				  	}, function(err2, result2){
				  		res.send(JSON.stringify(result));  	
					});
				  }else{
					  res.send(JSON.stringify(result));
				  }
		  }
			});
});
app.put('/', function(req, res){ 
	connection.query('DELETE from movie', function (error, result) {
		connection.query('insert into movie set=?', 
				JSON.parse(req.body.movies), function(error, result){
		  if (error) res.send(error);
		  else res.send(JSON.stringify(result));
		});
	});
});
app.put('/movie', function(req, res){ //학생정보 수정
	connection.query('UPDATE movie SET ? WHERE no=?', 
			[{
				category:Number(req.body.category),
				title:req.body.title,
				playdate:Date(req.body.playdate),
				runningtime:Number(req.body.runningtime),
				watchingRate:Number(req.body.watchingRate),
				nation:req.body.nation,
				totalAudience:Double(req.body.totalAudience),
				reviewPoint:Float(req.body.reviewPoint),
				actor:req.body.actor
			}, Number(req.body.no)],
			function (error, result) {
		  if (error) res.send(error);
		  else{
			  if(req.body.review != undefined){
				  var movie = dbObj.collection('movie');
				  movie.update({no:Number(req.body.no)},
						  {'$set':{review:req.body.review}},
						  function(err2, result2){
					  		res.send(JSON.stringify(result));
				  });
			  }else {
				res.send(JSON.stringify(result));
			  }
		  } 
		
	});
});
app.delete('/', function(req, res){ 
	connection.query('DELETE FROM movie', 
			function (error, result) {
		  if (error) res.send(error);
		  else res.send(JSON.stringify(result));
		});
});
app.delete('/movie', function(req, res){
	connection.query('DELETE FROM movie WHERE no=?', 
			
			Number(req.body.no),
			function (error, result) {
		  if (error) res.send(error);
		  else{ 
			  var movie = dbObj.collection('movie');
			  movie.remove({no:Number(req.body.no)}, function(err2, result2){
			  res.send(JSON.stringify(result));
			  });
		  }
		});
});
app.get('/users', user.list);

http.createServer(app).listen(app.get('port'), function(){
  console.log('Express server listening on port ' + app.get('port'));
});
