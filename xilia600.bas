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

 
clv2.AddTextItem("1502	ΚΑΤΗΓΟΡΙΑ 5.1	Υπερχλωρικό νάτριο	   " ,"")
clv2.AddTextItem("1503	ΚΑΤΗΓΟΡΙΑ 5.1	Υπερμαγγανικό νάτριο	   " ,"")   
clv2.AddTextItem("1504	ΚΑΤΗΓΟΡΙΑ 5.1	Υπεροξείδιο  νατρίου	   " ,"")   
clv2.AddTextItem("1505	ΚΑΤΗΓΟΡΙΑ 5.1	Υπερθετικό νάτριο	      " ,"")
clv2.AddTextItem("1506	ΚΑΤΗΓΟΡΙΑ 5.1	Στρόντιο χλωρικό	      " ,"")
clv2.AddTextItem("1507	ΚΑΤΗΓΟΡΙΑ 5.1	Νιτρικό στρόντιο	      " ,"")
clv2.AddTextItem("1508	ΚΑΤΗΓΟΡΙΑ 5.1	Στρόντιο υπερχλωρικό	   " ,"")   
clv2.AddTextItem("1509	ΚΑΤΗΓΟΡΙΑ 5.1	Υπεροξείδιο  στροντίου	   " ,"")   
clv2.AddTextItem("1510	ΚΑΤΗΓΟΡΙΑ 5.1	Τετρανιτρομεθανίου	      " ,"")
clv2.AddTextItem("1511	ΚΑΤΗΓΟΡΙΑ 5.1	Ουρία υπεροξείδιο  υδρογόνου	      " ,"")
clv2.AddTextItem("1512	ΚΑΤΗΓΟΡΙΑ 5.1	Ψευδάργυρος νιτρώδες αμμώνιο	   " ,"")   
clv2.AddTextItem("1513	ΚΑΤΗΓΟΡΙΑ 5.1	Χλωρικό ψευδαργύρου	      " ,"")
clv2.AddTextItem("1514	ΚΑΤΗΓΟΡΙΑ 5.1	Νιτρικού ψευδαργύρου	      " ,"")
clv2.AddTextItem("1515	ΚΑΤΗΓΟΡΙΑ 5.1	Υπερμαγγανικό ψευδαργύρου	      " ,"")
clv2.AddTextItem("1516	ΚΑΤΗΓΟΡΙΑ 5.1	Υπεροξείδιο  ψευδαργύρου	      " ,"")
clv2.AddTextItem("1517	ΚΑΤΗΓΟΡΙΑ 4.1	Ζιρκόνιο picramate    ", "")
clv2.AddTextItem("1541	ΚΑΤΗΓΟΡΙΑ 6.1	Ακετόνη κυανοϋδρίνης , σταθεροποιημένο	   " ,"")   
clv2.AddTextItem("1544	ΚΑΤΗΓΟΡΙΑ 6.1	Αλκαλοειδή       " ,"")
clv2.AddTextItem("1545	ΚΑΤΗΓΟΡΙΑ 6.1	ΙΣΟΘΕΙΟΚΥΑΝΙΚΟ ΑΛΛΥΛΙΟ , σταθεροποιημένο	      " ,"")
clv2.AddTextItem("1546	ΚΑΤΗΓΟΡΙΑ 6.1	Αρσενικικό αμμώνιο	      " ,"")
clv2.AddTextItem("1547	ΚΑΤΗΓΟΡΙΑ 6.1	Ανιλίνη	      " ,"")
clv2.AddTextItem("1548	ΚΑΤΗΓΟΡΙΑ 6.1	Ανιλίνης	      " ,"")
clv2.AddTextItem("1549	ΚΑΤΗΓΟΡΙΑ 6.1	Αντιμόνιο ενώσεις, ανόργανες, στερεά, 	      " ,"")
clv2.AddTextItem("1550	ΚΑΤΗΓΟΡΙΑ 6.1	Αντιμονίου γαλακτικό	   " ,"")   
clv2.AddTextItem("1551	ΚΑΤΗΓΟΡΙΑ 6.1	Αντιμόνιο τρυγικό κάλιο	   " ,"")   
clv2.AddTextItem("1553	ΚΑΤΗΓΟΡΙΑ 6.1	Αρσενικό οξύ , υγρό	      " ,"")
clv2.AddTextItem("1554	ΚΑΤΗΓΟΡΙΑ 6.1	Αρσενικό οξύ, στερεό	   " ,"")   
clv2.AddTextItem("1555	ΚΑΤΗΓΟΡΙΑ 6.1	Αρσενικό βρωμιούχο	   " ,"")   
clv2.AddTextItem("1556	ΚΑΤΗΓΟΡΙΑ 6.1	Αρσενικό ενώσεις	      " ,"")
clv2.AddTextItem("1557	ΚΑΤΗΓΟΡΙΑ 6.1	Ενώσεις αρσενικού,   " ,"")
clv2.AddTextItem("1558	ΚΑΤΗΓΟΡΙΑ 6.1	Αρσενικό	      " ,"")
clv2.AddTextItem("1559 	ΚΑΤΗΓΟΡΙΑ 6.1	Αρσενικό πεντοξείδιο	   " ,"")   
clv2.AddTextItem("1560	ΚΑΤΗΓΟΡΙΑ 6.1	Αρσενικό τριχλωριούχου	   " ,"")   
clv2.AddTextItem("1561	ΚΑΤΗΓΟΡΙΑ 6.1	Τριοξείδιο  αρσενικού   " ,"")	   
clv2.AddTextItem("1562	ΚΑΤΗΓΟΡΙΑ 6.1	Αρσενικού σκόνη	      " ,"")
clv2.AddTextItem("1564	ΚΑΤΗΓΟΡΙΑ 6.1	Βαρίου ενώσεις, 	      " ,"")
clv2.AddTextItem("1565	ΚΑΤΗΓΟΡΙΑ 6.1	Βάριο κυανίου	      " ,"")
clv2.AddTextItem("1566	ΚΑΤΗΓΟΡΙΑ 6.1	Βηρυλλίου ενώσεις, 	      " ,"")
clv2.AddTextItem("1567	ΚΑΤΗΓΟΡΙΑ 6.1	Βηρύλλιο, σκόνη	      " ,"")
clv2.AddTextItem("1569	ΚΑΤΗΓΟΡΙΑ 6.1	Βρωμοακετόνη	      " ,"")
clv2.AddTextItem("1570	ΚΑΤΗΓΟΡΙΑ 6.1	Βρυκίνης	      " ,"")
clv2.AddTextItem("1571	ΚΑΤΗΓΟΡΙΑ 4.1	Το αζίδιο  βαρίου , βρεγμένο	      " ,"")
clv2.AddTextItem("1572	ΚΑΤΗΓΟΡΙΑ 6.1	Κακωδυλικού οξύ	      " ,"")
clv2.AddTextItem("1573	ΚΑΤΗΓΟΡΙΑ 6.1	Αρσενικό ασβέστιο	      " ,"")
clv2.AddTextItem("1574	ΚΑΤΗΓΟΡΙΑ 6.1	Αρσενικό ασβέστιο και arsenite ασβέστιο , μίγματα, στερεά	      " ,"")
clv2.AddTextItem("1575	ΚΑΤΗΓΟΡΙΑ 6.1	Κυανιούχο ασβέστιο	      " ,"")
clv2.AddTextItem("1577	ΚΑΤΗΓΟΡΙΑ 6.1	Chlorodinitrobenzenes	      " ,"")
clv2.AddTextItem("1578	ΚΑΤΗΓΟΡΙΑ 6.1	Χλωρονιτροβενζόλιο , όρθο, υγρό	      " ,"")
clv2.AddTextItem("1579	ΚΑΤΗΓΟΡΙΑ 6.1	Xλωρο-ο-τολουϊδίνης υδροχλωρική	      " ,"")
clv2.AddTextItem("1580	ΚΑΤΗΓΟΡΙΑ 6.1	Χλωροπικρίνη	      " ,"")
clv2.AddTextItem("1581	ΚΑΤΗΓΟΡΙΑ 2	Χλωροπικρίνης και βρωμιούχου μεθυλίου μείγματα	      " ,"")
clv2.AddTextItem("1582	ΚΑΤΗΓΟΡΙΑ 2	Χλωροπικρίνης και χλωριούχου μεθυλίου μείγματα	    " ,"") 
clv2.AddTextItem("1583	ΚΑΤΗΓΟΡΙΑ 6.1	Μείγματα Χλωροπικρίνη, 	      " ,"")
clv2.AddTextItem("1585	ΚΑΤΗΓΟΡΙΑ 6.1	Acetoarsenite χαλκού	      " ,"")
clv2.AddTextItem("1586	ΚΑΤΗΓΟΡΙΑ 6.1	Αρσενικικώδους χαλκού	       " ,"")
clv2.AddTextItem("1587	ΚΑΤΗΓΟΡΙΑ 6.1	Κυανιούχου χαλκού	      " ,"")
clv2.AddTextItem("1588	ΚΑΤΗΓΟΡΙΑ 6.1	Κυανίδια , ανόργανα, στερεά, 	      " ,"")
clv2.AddTextItem("1589	ΚΑΤΗΓΟΡΙΑ 2	Χλωριούχο κυάνιο 	      " ,"")
clv2.AddTextItem("1590	ΚΑΤΗΓΟΡΙΑ 6.1	Dichloroanilines      " ,"")
clv2.AddTextItem("1591	ΚΑΤΗΓΟΡΙΑ 6.1	Oδιχλωροβενζόλιο	      " ,"")
clv2.AddTextItem("1593	ΚΑΤΗΓΟΡΙΑ 6.1	Διχλωρομεθάνιο	      " ,"")
clv2.AddTextItem("1594	ΚΑΤΗΓΟΡΙΑ 6.1	Θειικό διαιθύλιο	      " ,"")
clv2.AddTextItem("1595	ΚΑΤΗΓΟΡΙΑ 6.1	Θειικό διμεθύλιο	      " ,"")
clv2.AddTextItem("1596	ΚΑΤΗΓΟΡΙΑ 6.1	Δινιτροανιλίνες	      " ,"")
clv2.AddTextItem("1597	ΚΑΤΗΓΟΡΙΑ 6.1	Dinitrobenzenes , υγρό ή Dinitrobenzenes, στερεά	      " ,"")
clv2.AddTextItem("1598	ΚΑΤΗΓΟΡΙΑ 6.1	Δινιτρο-ο-κρεζόλη , στερεά ή Dintro-ο-κρεζόλη, διάλυμα   " ,"")	   
clv2.AddTextItem("1599	ΚΑΤΗΓΟΡΙΑ 6.1	Δινιτροφαινόλη	      " ,"")
 clv2.AddTextItem("1600	ΚΑΤΗΓΟΡΙΑ 6.1	Dinitrotoluenes	    " ,"")



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
