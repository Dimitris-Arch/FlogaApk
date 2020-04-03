B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=6.3
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: true
	#IncludeTitle: false
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
Dim sc As ScrollView
Dim ili As Button
Dim ousia As Button
Dim simansi As Button
Dim pixi As Button

Dim lista As Button

	Private katigor As Button
	
	Dim fakos As Label
	
	Private mple As ImageView
	Private simanseislabel As Label
	Private listabel As Label
	Private katigorlabel As Label
	Private ousialabel As Label
	Private ililabel As Label




	Dim Panel As Panel

	Dim clv2 As CustomListView
	
	Dim Panel2 As Panel
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("adr.bal")
    

		
		
 simanseislabel.Top = 3%y
simanseislabel.left = 3.5%x
simanseislabel.height = 27.5%y
simanseislabel.Width  = 45%x
   simansi.Top = 3%y
simansi.left = 3%x
simansi.height = 28%y
simansi.Width  = 45%x



''PANW DEXIA MESH
lista.Top = 3%y
lista.left = 51.5%x
lista.height = 13%y
lista.Width  = 21.25%x

listabel.Top = 3%y
listabel.left = 51.75%x
listabel.height = 13%y
listabel.Width  = 21.25%x



katigor.Top = 18%y
katigor.left = 51.50%x
katigor.height = 13%y
katigor.Width  = 21.25%x

katigorlabel.Top = 18%y
katigorlabel.left = 51.75%x
katigorlabel.height = 13%y
katigorlabel.Width  = 21.25%x
'PANW DEXIA AKRH
ousia.Top = 3%y
ousia.left = 75.75%x
ousia.height = 13%y
ousia.Width  = 21.25%x
ousialabel.Top = 3%y
ousialabel.left = 76%x
ousialabel.height = 13%y
ousialabel.Width  = 21.25%x

ili.Top = 18%y
ili.left = 75.75%x
ili.height = 13%y
ili.Width  = 21.25%x
ililabel.Top = 18%y
ililabel.left = 76%x
ililabel.height = 13%y
ililabel.Width  = 21.25%x
   

mple.top = 93%y
mple.left = 3%x
mple.width = 94%x
mple.height = 7%y


	
	

	
	
	
	
  
  
clv2.Initialize(Me, "clv2")
	Panel2.AddView(clv2.AsView, 0%x, 0%y,94%x ,57.5%y )
	 Panel2.Top = 33%y
  Panel2.Left = 3%x
  Panel2.Width = 94%x
  Panel2.Height = 57.5%y
	clv2.DefaultTextBackgroundColor = Colors.DarkGray

 
clv2.AddTextItem("1301	ΚΑΤΗΓΟΡΙΑ 3	Οξικό βινύλιο , αναστέλλεται	   " ,"")
clv2.AddTextItem("1302	ΚΑΤΗΓΟΡΙΑ 3	Αιθυλ βινυλ αιθέρας , παρεμπόδισε	   " ,"")   
clv2.AddTextItem("1303	ΚΑΤΗΓΟΡΙΑ 3	Χλωριούχο βινυλιδένιο , παρεμπόδισε	     " ,"") 
clv2.AddTextItem("1304	ΚΑΤΗΓΟΡΙΑ 3	Vinyl ισοβουτυλαιθέρα , αναστέλλεται	   " ,"") 
clv2.AddTextItem("1305	ΚΑΤΗΓΟΡΙΑ 3	Vinyltrichlorosilane , αναστέλλεται	   " ,"")   
clv2.AddTextItem("1306	ΚΑΤΗΓΟΡΙΑ 3	Συντηρητικά ξύλου , υγρό	      " ,"")
clv2.AddTextItem("1307	ΚΑΤΗΓΟΡΙΑ 3	Ξυλόλια	      " ,"")
clv2.AddTextItem("1308	ΚΑΤΗΓΟΡΙΑ 3	Ζιρκόνιο εναιωρείται σε ένα υγρό	   " ,"")   
clv2.AddTextItem("1309	ΚΑΤΗΓΟΡΙΑ 4.1	Αλουμίνιο σε σκόνη, με επικάλυψη	   " ,"")   
clv2.AddTextItem("1310	ΚΑΤΗΓΟΡΙΑ 4.1	Πικρικό αμμώνιο 	      " ,"")
clv2.AddTextItem("1312	ΚΑΤΗΓΟΡΙΑ 4.1	Βορνεόλη	      " ,"")
clv2.AddTextItem("1313	ΚΑΤΗΓΟΡΙΑ 4.1	Αβιετικός ασβεστίου	      " ,"")
clv2.AddTextItem("1314	ΚΑΤΗΓΟΡΙΑ 4.1	Αβιετικός ασβέστιο, λιωμένο	      " ,"")
clv2.AddTextItem("1318	ΚΑΤΗΓΟΡΙΑ 4.1	Κοβάλτιο αβιετικός , καθιζάνει	      " ,"")
clv2.AddTextItem("1320	ΚΑΤΗΓΟΡΙΑ 4.1	Δινιτροφαινόλης 	      " ,"")
clv2.AddTextItem("1321	ΚΑΤΗΓΟΡΙΑ 4.1	Dinitrophenolates	      " ,"")
clv2.AddTextItem("1322	ΚΑΤΗΓΟΡΙΑ 4.1	Dinitroresorcinol 	      " ,"")
clv2.AddTextItem("1323	ΚΑΤΗΓΟΡΙΑ 4.1	Ferrocerium	      " ,"")
clv2.AddTextItem("1324	ΚΑΤΗΓΟΡΙΑ 4.1	Ταινίες, νιτροκυτταρίνη βάση	      " ,"")
clv2.AddTextItem("1325	ΚΑΤΗΓΟΡΙΑ 4.1	Εύφλεκτα στερεά, οργανικά, 	      " ,"")
clv2.AddTextItem("1326	ΚΑΤΗΓΟΡΙΑ 4.1	Άφνιο σκόνη	      " ,"")
clv2.AddTextItem("1327	ΚΑΤΗΓΟΡΙΑ 4.1	Σανό, άχυρο ή Bhusa, υγρό, υγρό ή έχουν μολυνθεί με πετρέλαιο   " ,"")	   
clv2.AddTextItem("1328	ΚΑΤΗΓΟΡΙΑ 4.1	Εξαμεθυλενοτετραμίνη	      " ,"")
clv2.AddTextItem("1330	ΚΑΤΗΓΟΡΙΑ 4.1	Μαγγάνιο αβιετικός	      " ,"")
clv2.AddTextItem("1331	ΚΑΤΗΓΟΡΙΑ 4.1	Αγώνες , χτυπήσει οπουδήποτε	      " ,"")
clv2.AddTextItem("1332	ΚΑΤΗΓΟΡΙΑ 4.1	Μεταλδεΰδη	      " ,"")
clv2.AddTextItem("1333	ΚΑΤΗΓΟΡΙΑ 4.1	Δημήτριο , πλάκες, ράβδους, βέργες    " ,"")	   
clv2.AddTextItem("1334	ΚΑΤΗΓΟΡΙΑ 4.1	Ναφθαλίνης , ακατέργαστα ή ναφθαλίνης, εξευγενισμένα	   " ,"")   
clv2.AddTextItem("1336	ΚΑΤΗΓΟΡΙΑ 4.1	Νιτρογουανιδίνη , νωπό ή Picrite	      " ,"")
clv2.AddTextItem("1337	ΚΑΤΗΓΟΡΙΑ 4.1	Nitrostarch      " ,"")
clv2.AddTextItem("1338	ΚΑΤΗΓΟΡΙΑ 4.1	Φώσφορος , άμορφο	      " ,"")
clv2.AddTextItem("1339	ΚΑΤΗΓΟΡΙΑ 4.1	Φώσφορος heptasulfide , ελεύθερα από κίτρινο ή λευκό φώσφορο   " ,"")	   
clv2.AddTextItem("1340	ΚΑΤΗΓΟΡΙΑ 4.3	Πενταθειούχο φωσφόρο , ελεύθερα από κίτρινο ή λευκό φώσφορο	   " ,"")   
clv2.AddTextItem("1341	ΚΑΤΗΓΟΡΙΑ 4.1	Φώσφορος sesquisulfide , ελεύθερα από κίτρινο ή λευκό φώσφορο	   " ,"")   
clv2.AddTextItem("1343	ΚΑΤΗΓΟΡΙΑ 4.1	Φώσφορος τρισουλφίδιο , ελεύθερα από κίτρινο ή λευκό φώσφορο	   " ,"")   
clv2.AddTextItem("1344	ΚΑΤΗΓΟΡΙΑ 4.1	Τρινιτροφαινόλη   " ,"")
clv2.AddTextItem("1345	ΚΑΤΗΓΟΡΙΑ 4.1	Καουτσούκ θραύσματα ή κακής ποιότητας   " ,"")	   
clv2.AddTextItem("1346	ΚΑΤΗΓΟΡΙΑ 4.1	Πυρίτιο σκόνη, άμορφο	      " ,"")
clv2.AddTextItem("1347	ΚΑΤΗΓΟΡΙΑ 4.1	Ασήμι πικρικό 	      " ,"")
clv2.AddTextItem("1348	ΚΑΤΗΓΟΡΙΑ 4.1	Δινιτρο-ο-κρεζολικό νάτριο       " ,"")
clv2.AddTextItem("1349	ΚΑΤΗΓΟΡΙΑ 4.1	Picramate νάτριο       " ,"")
clv2.AddTextItem("1350	ΚΑΤΗΓΟΡΙΑ 4.1	Θείο	      " ,"")
clv2.AddTextItem("1352	ΚΑΤΗΓΟΡΙΑ 4.1	Τιτάνιο σκόνη    " ,"")
clv2.AddTextItem("1353	ΚΑΤΗΓΟΡΙΑ 4.1	Ίνες ή υφάσματα εμποτισμένα με ασθενώς νιτρωμένη νιτροκυτταρίνη, 	      " ,"")
clv2.AddTextItem("1354	ΚΑΤΗΓΟΡΙΑ 4.1	Τρινιτροβενζόλιο     " ,"")
clv2.AddTextItem("1355	ΚΑΤΗΓΟΡΙΑ 4.1	Τρινιτροβενζοϊκό οξύ	   " ,"")   
clv2.AddTextItem("1356	ΚΑΤΗΓΟΡΙΑ 4.1	Τρινιτροτολουένιο νωπή     " ,"")
clv2.AddTextItem("1357	ΚΑΤΗΓΟΡΙΑ 4.1	Νιτρικό ουρία 	      " ,"")
clv2.AddTextItem("1358	ΚΑΤΗΓΟΡΙΑ 4.1	Ζιρκόνιο σκόνη      " ,"")
clv2.AddTextItem("1360	ΚΑΤΗΓΟΡΙΑ 4.2	Φωσφορούχο ασβέστιο	    " ,"")  
clv2.AddTextItem("1361	ΚΑΤΗΓΟΡΙΑ 4.2	Άνθρακα , ζωικής ή φυτικής προέλευσης	      " ,"")
clv2.AddTextItem("1362	ΚΑΤΗΓΟΡΙΑ 4 2	Άνθρακας, ενεργοποιημένος	      " ,"")
clv2.AddTextItem("1363	ΚΑΤΗΓΟΡΙΑ 4.2	Ξηρά κοκοκάρυδα	      " ,"")
clv2.AddTextItem("1364	ΚΑΤΗΓΟΡΙΑ 4.2	Βαμβάκι αποβλήτων, τα λιπαρά   " ,"")	   
clv2.AddTextItem("1365	ΚΑΤΗΓΟΡΙΑ 4.2	Βαμβάκι, υγρή	      " ,"")
clv2.AddTextItem("1366	ΚΑΤΗΓΟΡΙΑ 4.2	Διαιθυλοψευδάργυρο	   " ,"")   
clv2.AddTextItem("1369	ΚΑΤΗΓΟΡΙΑ 4.2	Ρ-νιτροζο	      " ,"")
clv2.AddTextItem("1370	ΚΑΤΗΓΟΡΙΑ 4.2	Διμεθυλψευδαργύρου	   " ,"")   
clv2.AddTextItem("1373	ΚΑΤΗΓΟΡΙΑ 4.2	Ίνες ή υφάσματα, ζωικά ή φυτικά ή συνθετικά,  με ζωικό ή φυτικό έλαιο   " ,"")	   
clv2.AddTextItem("1374	ΚΑΤΗΓΟΡΙΑ 4.2	Ιχθυάλευρα , μη σταθεροποιημένα ή ψάρια θραύσματα	   " ,"")   
clv2.AddTextItem("1376	ΚΑΤΗΓΟΡΙΑ 4.2	Οξείδιο  σιδήρου 	      " ,"")
clv2.AddTextItem("1378	ΚΑΤΗΓΟΡΙΑ 4.2	Μέταλλο  καταλύτη , διαβρέχεται με ορατή περίσσεια υγρού	      " ,"")
clv2.AddTextItem("1379	ΚΑΤΗΓΟΡΙΑ 4.2	Χαρτί , ακόρεστο λάδι ,καρμπόν	      " ,"")
clv2.AddTextItem("1380	ΚΑΤΗΓΟΡΙΑ 4.2	Pentaborane	      " ,"")
clv2.AddTextItem("1381	ΚΑΤΗΓΟΡΙΑ 4.2	Φωσφόρος, λευκός ξηρός ή φωσφόρος, λευκός   " ,"")
clv2.AddTextItem("1382	ΚΑΤΗΓΟΡΙΑ 4.2	Θειούχο κάλιο , άνυδρο ή Κάλιο σουλφίδιο	   " ,"")   
clv2.AddTextItem("1383	ΚΑΤΗΓΟΡΙΑ 4.2	Πυροφορικό μετάλλων,  ή Πυροφορικά κράματα, 	      " ,"")
clv2.AddTextItem("1384	ΚΑΤΗΓΟΡΙΑ 4.2	Διθειονώδης νάτριο ή υδροθειώδες νάτριο	      " ,"")
clv2.AddTextItem("1385	ΚΑΤΗΓΟΡΙΑ 4.2	Θειούχο νάτριο , άνυδρο ή νάτριο σουλφίδιο	      " ,"")
clv2.AddTextItem("1389	ΚΑΤΗΓΟΡΙΑ 4.3	Αλκαλίων και αμάλγαμα , υγρό ή αλκαλίων και αμάλγαμα, στερεά	   " ,"")   
clv2.AddTextItem("1390	ΚΑΤΗΓΟΡΙΑ 4.3	Αμίδια αλκαλιμετάλλου	      " ,"")
clv2.AddTextItem("1391	ΚΑΤΗΓΟΡΙΑ 4.3	Αλκαλιμετάλλου διασπορές, ή μετάλλου αλκαλικής γαίας διασπορές   " ,"")	   
clv2.AddTextItem("1392	ΚΑΤΗΓΟΡΙΑ 4.3	Αλκαλικής γαίας μέταλλο αμαλγάματα	      " ,"")
clv2.AddTextItem("1393	ΚΑΤΗΓΟΡΙΑ 4.3	Μετάλλου αλκαλικής γαίας κράματα , nos	     " ,"") 
clv2.AddTextItem("1394	ΚΑΤΗΓΟΡΙΑ 4.3	Αλουμίνιο καρβίδιο	      " ,"")
clv2.AddTextItem("1395	ΚΑΤΗΓΟΡΙΑ 4.3	ΣιδηροπυρΙτιο Αλουμινίου σκόνη	      " ,"")
clv2.AddTextItem("1396	ΚΑΤΗΓΟΡΙΑ 4.3	Αλουμίνιο σε σκόνη, χωρίς επικάλυψη	      " ,"")
clv2.AddTextItem("1397	ΚΑΤΗΓΟΡΙΑ 4.3	Φωσφορούχο αργίλιο	      " ,"")
clv2.AddTextItem("1398	ΚΑΤΗΓΟΡΙΑ 4.3	Αλουμινίου πυριτίου σε σκόνη, χωρίς επικάλυψη	      " ,"")
 clv2.AddTextItem("1400	ΚΑΤΗΓΟΡΙΑ 4.3	Βάριο	    " ,"")

End Sub

Sub clv1_ItemClick (Index As Int, Value As Object)
	Activity.Title = Value
End Sub

Sub CreateListItem(Text As String, Width As Int, Height As Int) As Panel
	Dim p As Panel
	p.Initialize("")
	p.Color = Colors.Black
	Dim b As Button
	b.Initialize("button") 'all buttons click events will be handled with Sub Button_Click
	Dim chk As CheckBox
	chk.Initialize("")
	Dim lbl As Label
	lbl.Initialize("")
	lbl.Gravity = Bit.OR(Gravity.CENTER_VERTICAL, Gravity.LEFT)
	lbl.Text = Text
	lbl.TextSize = 16
	lbl.TextColor = Colors.White
	b.Text = "Click"
	p.AddView(lbl, 5dip, 2dip, 150dip, Height - 4dip) 'view #0
	p.AddView(b, 155dip, 2dip, 110dip, Height - 4dip) 'view #1
	p.AddView(chk, 280dip, 2dip, 50dip, Height - 4dip) 'view #2
	Return p
End Sub



Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)
Activity.Finish
End Sub
Sub ili_Click
	StartActivity("ilika")
End Sub
Sub ousia_Click
	StartActivity("ousies")
End Sub
Sub pixi_Click
	StartActivity("pixida")
End Sub

Sub lista_Click
	StartActivity("listaousies")
End Sub

Sub katigor_Click
	StartActivity("katigoriess")
End Sub
Sub gpss_Click
	
StartActivity("gpssingal")
End Sub

Sub simanseislabel_Click
	StartActivity("Main")
End Sub
Sub listabel_Click
	StartActivity("listaousies")
End Sub
Sub katigorlabel_Click
	StartActivity("katigoriess")
End Sub
Sub ousialabel_Click
	StartActivity("ousies")
End Sub
Sub ililabel_Click
	StartActivity("ilika")
End Sub

Sub simansi_Click
	StartActivity("Main")
End Sub


Sub Activity_KeyPress (KeyCode As Int) As Boolean
    If KeyCode = KeyCodes.KEYCODE_BACK Then
      
             Activity.Finish
       End If
End Sub
