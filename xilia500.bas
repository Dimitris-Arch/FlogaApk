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
'Dim AdView1 As AdView
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
    

'AdView1.Initialize("Ad", "ca-app-pub-6889311870331566/2287503739")
'	 Activity.AddView(AdView1, 0dip, 100%y - 50dip, 100%x, 50dip)
 '  AdView1.LoadAd
	
		
		
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

 

 clv2.AddTextItem("1401	ΚΑΤΗΓΟΡΙΑ 4.3	Ασβέστιο	   " ,"")
 clv2.AddTextItem("1402	ΚΑΤΗΓΟΡΙΑ 4.3	Καρβίδιο ασβεστίου" ,"")	   
 clv2.AddTextItem("1403	ΚΑΤΗΓΟΡΙΑ 4.3	Ασβεστοκυαναμίδιο με περισσότερα από 0,1 τοις εκατό του καρβιδίου του ασβεστίου	 " ,"")  
 clv2.AddTextItem("1404	ΚΑΤΗΓΟΡΙΑ 4.3	Υδρίδιο ασβεστίου	   " ,"")
 clv2.AddTextItem("1405	ΚΑΤΗΓΟΡΙΑ 4.3	Πυριτιούχο ασβέστιο	   " ,"")
 clv2.AddTextItem("1407	ΚΑΤΗΓΟΡΙΑ 4.3	Καίσιο   " ,"")
 clv2.AddTextItem("1408	ΚΑΤΗΓΟΡΙΑ 4.3	Σιδηροπυρίτιο , με 30 τοις εκατό ή περισσότερο αλλά λιγότερο από το 90 τοις εκατό του πυριτίου	" ,"")   
 clv2.AddTextItem("1409	ΚΑΤΗΓΟΡΙΑ 4.3	Υδρίδια μετάλλων , αντιδρώντα με νερό, ε.α.ο.	   " ,"")
 clv2.AddTextItem("1410	ΚΑΤΗΓΟΡΙΑ 4.3	Υδρίδιο λιθίου αργιλίου	   " ,"")
 clv2.AddTextItem("1411	ΚΑΤΗΓΟΡΙΑ 4.3	Λίθιο αργίλιο υδρίδιο, αιθερικό	   " ,"")
 clv2.AddTextItem("1413	ΚΑΤΗΓΟΡΙΑ 4.3	Βοροϋδρίδιο του λιθίου	   " ,"")
 clv2.AddTextItem("1414	ΚΑΤΗΓΟΡΙΑ 4.3	Υδρίδιο λιθίου	   " ,"")
 clv2.AddTextItem("1415	ΚΑΤΗΓΟΡΙΑ 4.3	Λίθιο	   " ,"")
 clv2.AddTextItem("1417	ΚΑΤΗΓΟΡΙΑ 4.3	Πυριτίου λιθίου	   " ,"")
 clv2.AddTextItem("1418	ΚΑΤΗΓΟΡΙΑ 4.3	Μαγνήσιο , σκόνη ή κραμάτων μαγνησίου, σκόνη	   " ,"")
 clv2.AddTextItem("1419	ΚΑΤΗΓΟΡΙΑ 4.3	Μαγνήσιο φωσφορούχο αργίλιο	   " ,"")
 clv2.AddTextItem("1420	ΚΑΤΗΓΟΡΙΑ 4.3	Κάλιο , μεταλλικά κράματα	   " ,"")
 clv2.AddTextItem("1421	ΚΑΤΗΓΟΡΙΑ 4.3	Αλκαλικών μετάλλων κράματα, υγρό, nos	   " ,"")
 clv2.AddTextItem("1422	ΚΑΤΗΓΟΡΙΑ 4.3	Κάλιο νάτριο κράματα	   " ,"")
 clv2.AddTextItem("1423	ΚΑΤΗΓΟΡΙΑ 4.3	Ρουβίνιο	   " ,"")
 clv2.AddTextItem("1426	ΚΑΤΗΓΟΡΙΑ 4.3	Βοροϋδρίδιο νατρίου	   " ,"")
 clv2.AddTextItem("1427	ΚΑΤΗΓΟΡΙΑ 4.3	Υδρίδιο του νατρίου	   " ,"")
 clv2.AddTextItem("1428	ΚΑΤΗΓΟΡΙΑ 4.3	Νάτριο	   " ,"")
 clv2.AddTextItem("1431	ΚΑΤΗΓΟΡΙΑ 4.2	Μεθυλικό νάτριο	   " ,"")
 clv2.AddTextItem("1432	ΚΑΤΗΓΟΡΙΑ 4.3	Φωσφορούχο νάτριο	   " ,"")
 clv2.AddTextItem("1433	ΚΑΤΗΓΟΡΙΑ 4.3	Κασσιτερικά φωσφορούχο	   " ,"")
 clv2.AddTextItem("1435	ΚΑΤΗΓΟΡΙΑ 4.3	Ψευδάργυρος στάχτες	   " ,"")
 clv2.AddTextItem("1436	ΚΑΤΗΓΟΡΙΑ 4.3	Σκόνη ψευδαργύρου ή σκόνη ψευδαργύρου	   " ,"")
 clv2.AddTextItem("1437	ΚΑΤΗΓΟΡΙΑ 4.1	Ζιρκόνιο υδριδίου	   " ,"")
 clv2.AddTextItem("1438	ΚΑΤΗΓΟΡΙΑ 5.1	Νιτρικό αργίλιο	   " ,"")
 clv2.AddTextItem("1439	ΚΑΤΗΓΟΡΙΑ 5.1	Διχρωμικό αμμώνιο" ,"")
 clv2.AddTextItem("1442	ΚΑΤΗΓΟΡΙΑ 5.1	Υπερχλωρικό αμμώνιο	   " ,"")
 clv2.AddTextItem("1444	ΚΑΤΗΓΟΡΙΑ 5.1	Υπερθετικό αμμώνιο	   " ,"")
 clv2.AddTextItem("1445	ΚΑΤΗΓΟΡΙΑ 5.1	Βάριο χλωρικό	   " ,"")
 clv2.AddTextItem("1446	ΚΑΤΗΓΟΡΙΑ 5.1	Νιτρικό βάριο	   " ,"")
 clv2.AddTextItem("1447	ΚΑΤΗΓΟΡΙΑ 5.1	Βάριο υπερχλωρικό	   " ,"")
 clv2.AddTextItem("1448	ΚΑΤΗΓΟΡΙΑ 5.1	Βάριο υπερμαγγανικού	   " ,"")
 clv2.AddTextItem("1449	ΚΑΤΗΓΟΡΙΑ 5.1	Υπεροξείδιο του βαρίου	   " ,"")
 clv2.AddTextItem("1450	ΚΑΤΗΓΟΡΙΑ 5.1	Βρωμικών , ανόργανα, ε.α.ο.	   " ,"")
 clv2.AddTextItem("1451	ΚΑΤΗΓΟΡΙΑ 5.1	Νιτρικό καίσιο ή νιτρικό καίσιο	   " ,"")
 clv2.AddTextItem("1452	ΚΑΤΗΓΟΡΙΑ 5.1	Χλωρικό ασβέστιο	   	   " ,"")
 clv2.AddTextItem("1454	ΚΑΤΗΓΟΡΙΑ 5.1	Νιτρικό ασβέστιο	   " ,"")
 clv2.AddTextItem("1455	ΚΑΤΗΓΟΡΙΑ 5.1	Υπερχλωρικό ασβέστιο	   " ,"")
 clv2.AddTextItem("1456	ΚΑΤΗΓΟΡΙΑ 5.1	Υπερμαγγανικό ασβεστίου" ,"")
 clv2.AddTextItem("1457	ΚΑΤΗΓΟΡΙΑ 5.1	Υπεροξείδιο ασβεστίου	   " ,"")
 clv2.AddTextItem("1458	ΚΑΤΗΓΟΡΙΑ 5.1	Χλωρικό και βορικού μείγματα	   " ,"")
clv2.AddTextItem("1459	ΚΑΤΗΓΟΡΙΑ 5.1	Chlorat und Magnesiumchlorid, Mischung	   " ,"")
 clv2.AddTextItem("1461	ΚΑΤΗΓΟΡΙΑ 5.1	Χλωρικά, ανόργανα, ε.α.ο." ,"")
 clv2.AddTextItem("1462	ΚΑΤΗΓΟΡΙΑ 5.1	Χλωριώδεις , ανόργανα, ε.α.ο.	   " ,"")
 clv2.AddTextItem("1463	ΚΑΤΗΓΟΡΙΑ 5.1	Τριοξείδιο του χρωμίου , άνυδρο	   " ,"")
 clv2.AddTextItem("1465	ΚΑΤΗΓΟΡΙΑ 5.1	Νιτρικό διδύμιον	   " ,"")
 clv2.AddTextItem("1466	ΚΑΤΗΓΟΡΙΑ 5.1	Νιτρικό σίδηρο" ,"")
 clv2.AddTextItem("1467	ΚΑΤΗΓΟΡΙΑ 5.1	Νιτρικό Γουανιδίνη	   " ,"")
 clv2.AddTextItem("1469	ΚΑΤΗΓΟΡΙΑ 5.1	Νιτρικού μολύβδου	   " ,"")
 clv2.AddTextItem("1470	ΚΑΤΗΓΟΡΙΑ 5.1	Μόλυβδος υπερχλωρικό , στερεά ή μόλυβδο, υπερχλωρικό λύση	   " ,"")
 clv2.AddTextItem("1471	ΚΑΤΗΓΟΡΙΑ 5.1	Το υποχλωριώδες λίθιο , ξηρό ή μείγματα υποχλωριώδους λιθίου, ξηρό	   " ,"")
 clv2.AddTextItem("1472	ΚΑΤΗΓΟΡΙΑ 5.1	Υπεροξείδιο του λιθίου	   " ,"")
 clv2.AddTextItem("1473	ΚΑΤΗΓΟΡΙΑ 5.1	Βρωμικό μαγνήσιο	   " ,"")
 clv2.AddTextItem("1474	ΚΑΤΗΓΟΡΙΑ 5.1	Νιτρικό μαγνήσιο" ,"")
 clv2.AddTextItem("1475	ΚΑΤΗΓΟΡΙΑ 5.1	Υπερχλωρικό μαγνήσιο	   " ,"")
 clv2.AddTextItem("1476	ΚΑΤΗΓΟΡΙΑ 5.1	Υπεροξείδιο μαγνησίου	   " ,"")
 clv2.AddTextItem("1477	ΚΑΤΗΓΟΡΙΑ 5.1	Νιτρικά άλατα , ανόργανα, ε.α.ο.	   ." ,"")
 clv2.AddTextItem("1481	ΚΑΤΗΓΟΡΙΑ 5.1	Υπερχλωρικές , ανόργανα, ε.α.ο.	   " ,"")
 clv2.AddTextItem("1482	ΚΑΤΗΓΟΡΙΑ 5.1	Υπερμαγγανικά , ανόργανα, ε.α.ο." ,"")
 clv2.AddTextItem("1484	ΚΑΤΗΓΟΡΙΑ 5.1	Βρωμικό κάλιο	   " ,"")
 clv2.AddTextItem("1485	ΚΑΤΗΓΟΡΙΑ 5.1	Χλωρικό κάλιο	   " ,"")
 clv2.AddTextItem("1486	ΚΑΤΗΓΟΡΙΑ 5.1	Νιτρικό κάλιο" ,"")
 clv2.AddTextItem("1487	ΚΑΤΗΓΟΡΙΑ 5.1	Νιτρικό κάλιο και νιτρώδες νάτριο μείγματα	   " ,"")
 clv2.AddTextItem("1488	ΚΑΤΗΓΟΡΙΑ 5.1	Νιτρώδες κάλιο	   " ,"")
 clv2.AddTextItem("1489	ΚΑΤΗΓΟΡΙΑ 5.1	Υπερχλωρικό κάλιο , στερεά ή κάλιο, υπερχλωρικό διάλυμα" ,"")
 clv2.AddTextItem("1490	ΚΑΤΗΓΟΡΙΑ 5.1	Υπερμαγγανικό κάλιο	   " ,"")
 clv2.AddTextItem("1491	ΚΑΤΗΓΟΡΙΑ 5.1	Υπεροξείδιο του καλίου" ,"")
 clv2.AddTextItem("1492	ΚΑΤΗΓΟΡΙΑ 5.1	Υπερθειικό κάλιο	   " ,"")
 clv2.AddTextItem("1493	ΚΑΤΗΓΟΡΙΑ 5.1	Νιτρικού αργύρου" ,"")
 clv2.AddTextItem("1494	ΚΑΤΗΓΟΡΙΑ 5.1	Βρώμικο νάτριο	   	   " ,"")
 clv2.AddTextItem("1496	ΚΑΤΗΓΟΡΙΑ 5.1	Χλωριούχο νάτριο" ,"")
 clv2.AddTextItem("1498	ΚΑΤΗΓΟΡΙΑ 5.1	Νιτρικό νάτριο	   " ,"")
 clv2.AddTextItem("1499	ΚΑΤΗΓΟΡΙΑ 5.1	Νιτρικό νάτριο και νιτρικό κάλιο μείγματα	   " ,"")
 clv2.AddTextItem("1500	ΚΑΤΗΓΟΡΙΑ 5.1	Νιτρώδες νάτριο	" ,"")

End Sub

Sub clv1_ItemClick (Index As Int, Value As Object)
	
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
	lbl.Gravity = Bit.Or(Gravity.CENTER_VERTICAL, Gravity.LEFT)
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
