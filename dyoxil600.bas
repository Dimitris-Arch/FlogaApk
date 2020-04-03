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

 
clv2.AddTextItem("2501	Κατηγορία 6.1	Τρις- (Κατηγορία 1-αζιριδινυλο) φωσφινοξείδιο , διάλυμα	    ", "")
clv2.AddTextItem("2502	Κατηγορία 8	Βαλερυλο χλωριούχο	    ", "")
clv2.AddTextItem("2503	Κατηγορία 8	Τετραχλωριούχου ζιρκονίου	    ", "")
clv2.AddTextItem("2504	Κατηγορία 6.1	Tetrabromoethane	    ", "")
clv2.AddTextItem("2505	Κατηγορία 6.1	Φθοριούχο αμμώνιο	    ", "")
clv2.AddTextItem("2506	Κατηγορία 8	Θειικό αμμώνιο υδρογόνο	    ", "")
clv2.AddTextItem("2507	Κατηγορία 8	Χλωρολευκοχρυσικό οξύ , στερεό	    ", "")
clv2.AddTextItem("2508	Κατηγορία 8	Μολυβδαίνιο Πενταχλωριούχος	    ", "")
clv2.AddTextItem("2509	Κατηγορία 8	Όξινου θειικού καλίου	    ", "")
clv2.AddTextItem("2511	Κατηγορία 8	Κατηγορία 2-χλωροπροπιονικού οξέος	    ", "")
clv2.AddTextItem("2512	Κατηγορία 6.1	Αμινοφαινολών  ", "")
clv2.AddTextItem("2513	Κατηγορία 8	Βρωμιούχο βρωμοακετυλιο	    ", "")
clv2.AddTextItem("2514	Κατηγορία 3	Βρωμοβενζινο	    ", "")
clv2.AddTextItem("2515	Κατηγορία 6.1	Βρωμοφόρμιο	    ", "")
clv2.AddTextItem("2516	Κατηγορία 6.1	Τετραβρωμάνθρακα	    ", "")
clv2.AddTextItem("2517	Κατηγορία 2	Χλωρο-Κατηγορία 1,Κατηγορία 1-διφθοροαιθάνιο ή ψυκτικό αέριο R 142b	 ", "")   
clv2.AddTextItem("2520	Κατηγορία 3	Cyclooctadienes	    ", "")
clv2.AddTextItem("2521	Κατηγορία 6.1	Δικετένιο , αναστέλλεται	    ", "")
clv2.AddTextItem("2522	Κατηγορία 6.1	Μεθακρυλικό Κατηγορία 2-διμεθυλαμινοαιθυλ	 ", "")   
clv2.AddTextItem("2524	Κατηγορία 3	Ορθομυρμηκικό αιθυλεστέρα	    ", "")
clv2.AddTextItem("2525	Κατηγορία 6.1	Ethyl οξαλικό	    ", "")
clv2.AddTextItem("2526	Κατηγορία 3	Φουρφουρυλαμίνη	    ", "")
clv2.AddTextItem("2527	Κατηγορία 3	Ακρυλικό ισοβουτυλεστέρα  ", "")
clv2.AddTextItem("2528	Κατηγορία 3	Ισοβουτυρικός ισοβουτυλ	 ", "")   
clv2.AddTextItem("2529	Κατηγορία 3	Ισοβουτυρικό οξύ	    ", "")
clv2.AddTextItem("2530	Κατηγορία 3	Ισοβουτυρικό ανυδρίτη	    ", "")
clv2.AddTextItem("2531	Κατηγορία 8	Μεθακρυλικό οξύ , αναστέλλεται	 ", "")   
clv2.AddTextItem("2533	Κατηγορία 6.1	Τριχλωροξικό μεθυλεστέρα	    ", "")
clv2.AddTextItem("2534	Κατηγορία 2	Methylchlorosilane	    ", "")
clv2.AddTextItem("2535	Κατηγορία 3	Κατηγορία 4-μεθυλμορφολίνη ή Ν-μεθυλομορφολίνη ", "")	   
clv2.AddTextItem("2536	Κατηγορία 3	Μεθυλοτετραϋδροφουράνης	    ", "")
clv2.AddTextItem("2538	Κατηγορία 4.1	Nitronaphthalene	    ", "")
clv2.AddTextItem("2541	Κατηγορία 3	Τερπινολένιο	    ", "")
clv2.AddTextItem("2542	Κατηγορία 6.1	Τριβουτυλαμίνη	    ", "")
clv2.AddTextItem("2545	Κατηγορία 4.2	Άφνιο σκόνη, ξηρό	    ", "")
clv2.AddTextItem("2546	Κατηγορία 4.2	Τιτάνιο σκόνη, ξηρό	    ", "")
clv2.AddTextItem("2547	Κατηγορία 5.1	Υπεροξειδίου  νατρίου	    ", "")
clv2.AddTextItem("2548	Κατηγορία 2	Χλώριο πενταφθοριούχο	    ", "")
clv2.AddTextItem("2552	Κατηγορία 6.1	Ένυδρο εξαφθοροακετόνης	    ", "")
clv2.AddTextItem("2554	Κατηγορία 3	Χλωριούχο μεθύλιο αλλυλ	    ", "")
clv2.AddTextItem("2555	Κατηγορία 4.1	Νιτροκυτταρίνη με νερό με όχι λιγότερο από 25 τοις εκατό νερό, κατά βάρος	 ", "")   
clv2.AddTextItem("2556	Κατηγορία 4.1	Νιτροκυτταρίνη, με αλκοόλη με όχι λιγότερο από 25 τοις εκατό αλκοόλη ", "")
clv2.AddTextItem("2557	Κατηγορία 4.1	Νιτροκυτταρίνη, με όχι περισσότερο από 12,Κατηγορία 6 τοις εκατό άζωτο ", "")
clv2.AddTextItem("2558	Κατηγορία 6.1	Επιβρωμοϋδρίνη	    ", "")
clv2.AddTextItem("2560	Κατηγορία 3	Μεθυλπεντανιο", "")
clv2.AddTextItem("2561	Κατηγορία 3	Βουτένιο	    ", "")
clv2.AddTextItem("2564	Κατηγορία 8	Τριχλωροξικό οξύ , διάλυμα	    ", "")
clv2.AddTextItem("2565	Κατηγορία 8	Δικυκλοεξυλαμίνη	    ", "")
clv2.AddTextItem("2567	Κατηγορία 6.1	Πενταχλωροφαινόλης	    ", "")
clv2.AddTextItem("2570	Κατηγορία 6.1	Κάδμιο ενώσεις	    ", "")
clv2.AddTextItem("2571	Κατηγορία 8	Alkylsulfuric οξέα	    ", "")
clv2.AddTextItem("2572	Κατηγορία 6.1	Φαινυλυδραζινικού	    ", "")
clv2.AddTextItem("2573	Κατηγορία 5.1	Θάλλιο χλωρικό	    ", "")
clv2.AddTextItem("2574	Κατηγορία 6.1	Φωσφορικό τρικρεσυλεστέρα με περισσότερα από Κατηγορία 3 τοις εκατό ορθο ισομερές ", "")	   
clv2.AddTextItem("2576	Κατηγορία 8	Οξυβρωμιούχου φωσφόρου , λιωμένο	    ", "")
clv2.AddTextItem("2577	Κατηγορία 8	Φαινυλακετυλ χλωρίδιο	    ", "")
clv2.AddTextItem("2578	Κατηγορία 8	Φώσφορος τριοξείδιο	 ", "")   
clv2.AddTextItem("2579	Κατηγορία 8	Πιπεραζινική	    ", "")
clv2.AddTextItem("2580	Κατηγορία 8	Βρωμιούχο αργίλιο , διάλυμα	    ", "")
clv2.AddTextItem("2581	Κατηγορία 8	Χλωριούχο αργίλιο , διάλυμα	    ", "")
clv2.AddTextItem("2582	Κατηγορία 8	Χλωριούχου σιδήρου , διάλυμα	    ", "")
clv2.AddTextItem("2583	Κατηγορία 8	Αλκύλ σουλφονικά οξέα	    ", "")
clv2.AddTextItem("2587	Κατηγορία 6.1	Βενζοκινόνη	    ", "")
clv2.AddTextItem("2588	Κατηγορία 6.1	Φυτοφάρμακα , στερεά, τοξικά ", "")	   
clv2.AddTextItem("2589	Κατηγορία 6.1	Vinyl χλωροξικόν	    ", "")
clv2.AddTextItem("2590	Κατηγορία 9	Λευκό αμίαντο ( χρυσοτίλη , ακτινολίτης , ανθοφυλλίτης , τρεμόλιθος ) ", "")	   
clv2.AddTextItem("2591	Κατηγορία 2	Προβολείς Xenon , κατεψυγμένου υγρού (κρυογονική υγρά)	    ", "")
clv2.AddTextItem("2599	Κατηγορία 2	Χλωροτριφθορομεθάνιο και τριφθορομεθάνιου	    ", "")
   clv2.AddTextItem("2600	Κατηγορία 2	Μονοξείδιο  άνθρακα και υδρογόνο μίγμα, συμπιέζεται ", "")

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
