<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Olympic Picture Search Welcome Page</title>
    </head>
    <body>
        <h1><center>Olympic Picture Search</center></h1>
        <p>Choose a sport to display a picture of an Olympic athlete and a menu of sports to choose from.</p>
        <form action="OlympicPictureSearchServlet" method="GET">
            <label for="letter">Search an athlete</label>
            <input type="text" name="search" value="" /><br>
            <select name="sportsCategory">
                        <option selected="selected" value="noSelection">Please select a sport</option>
			<option value="1313719">Alpine Skiing</option>
                <option value="1313713">Archery</option>
                <option value="1313887">Artistic Gymnastics</option>
                <option value="1313725">Athletics</option>
                <option value="1313737">Badminton</option>
                <option value="1313743">Basketball</option>
                <option value="1313965">Basque Pelota</option>
                <option value="1313761">Beach volleyball</option>
                <option value="1313767">Boxing</option>
                <option value="1313785">Canoe / Kayak Flatwater</option>
                <option value="1313803">Croquet</option>
                <option value="1313773">Cycling BMX</option>
                <option value="1313809">Cycling Road</option>
                <option value="1313821">Cycling Track</option>
                <option value="1313833">Diving</option>
                <option value="10370494">Equestrian</option>
                <option value="1313845">Equestrian / Dressage</option>
                <option value="1313839">Equestrian / Eventing</option>
                <option value="1313851">Equestrian / Jumping</option>
                <option value="1313857">Equestrian / Vaulting</option>
                <option value="1313869">Fencing</option>
                <option value="1313881">Figure skating</option>
                <option value="1313863">Football</option>
                <option value="1313875">Freestyle Skiing</option>
                <option value="1313893">Golf</option>
                <option value="1313911">Handball</option>
                <option value="1313917">Hockey</option>
                <option value="1313923">Ice Hockey</option>
                <option value="1313929">Jeu de Paume</option>
                <option value="1313935">Judo</option>
                <option value="1313941">Lacrosse</option>
                <option value="1313947">Luge</option>
                <option value="1313953">Modern Pentathlon</option>
                <option value="1313797">Mountain Bike</option>
                <option value="1313959">Nordic Combined</option>
                <option value="1313971">Polo</option>
                <option value="1313983">Rackets</option>
                <option value="1313899">Rhythmic Gymnastics</option>
                <option value="1313977">Rink-Hockey</option>
                <option value="1313995">Roque</option>
                <option value="1313989">Rowing</option>
                <option value="1314001">Rugby</option>
                <option value="1314007">Sailing</option>
                <option value="1314019">Shooting</option>
                <option value="1314049">Short Track Speed Skating</option>
                <option value="1314031">Skeleton</option>
                <option value="1314025">Ski Jumping</option>
                <option value="1314013">Snowboard</option>
                <option value="1314037">Softball</option>
                <option value="1314043">Speed skating</option>
                <option value="1314055">Speed skiing</option>
                <option value="1314061">Swimming</option>
                <option value="1314067">Synchronized Swimming</option>
                <option value="1314097">Table Tennis</option>
                <option value="1314085">Taekwondo</option>
                <option value="1314073">Tennis</option>
                <option value="1313905">Trampoline</option>
                <option value="1314091">Triathlon</option>
                <option value="1314079">Tug of War</option>
                <option value="1314103">Volleyball</option>
                <option value="1314127">Water Motorsports</option>
                <option value="1314133">Water polo</option>
                <option value="1314139">Water Skiing</option>
                <option value="1314121">Weightlifting</option>
                <option value="10370509">Wrestling</option>
                <option value="1314109">Wrestling Freestyle</option>
		</select><br />
            <input type="submit" value="Submit" />
        </form>
    </body>
</html>
