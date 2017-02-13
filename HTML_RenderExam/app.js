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
  database : 'didimdol'
});
connection.connect();	

app.get('/', function(req, res){
	connection.query('select * from student', function(err, results, fields){
		if(err) res.send(err);
		else console.log(JSON.stringify(results)),res.render('index', {title:'JAVA C반 교육생 명단', students:results});
	});
});
app.post('/insert', function(req,res){
	connection.query('insert into student set ?',
			{
				no:Number(req.body.no),
				name:req.body.name,
				gender:req.body.gender,
				major:req.body.major,
				city:req.body.city,
				team:req.body.team
			}, function(err, result){
				res.redirect('/');
			});
});
app.post('/update', function(req,res){
	connection.query('update student set ? where no=?',
			[
				{
					name:req.body.name,
					gender:req.body.gender,
					major:req.body.major,
					city:req.body.city,
					team:req.body.team
				}, Number(req.body.no)
			], function(err, result){
				res.redirect('/');
			});
});
app.post('/delete', function(req,res){
	connection.query('delete from student where no=?',
		Number(req.body.no),
		function(err,result){
			res.redirect('/');
	});
});

/*app.get('/', routes.index);*/
app.get('/users', user.list);

http.createServer(app).listen(app.get('port'), function(){
  console.log('Express server listening on port ' + app.get('port'));
});
