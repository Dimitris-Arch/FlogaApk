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

 
clv2.AddTextItem("2401	Κατηγορία 8	Πιπεριδίνη	    ", "")
clv2.AddTextItem("2402	Κατηγορία 3	Propanethiols	    ", "")
clv2.AddTextItem("2403	Κατηγορία 3	Οξικό ισοπροπενυλεστέρα	    ", "")
clv2.AddTextItem("2404	Κατηγορία 3	Προπιονιτρίλιον	    ", "")
clv2.AddTextItem("2405	Κατηγορία 3	Ισοπροπυλική βουτυρικό	    ", "")
clv2.AddTextItem("2406	Κατηγορία 3	Ισοπροπυλική ισοβουτυρικής	    ", "")
clv2.AddTextItem("2407	Κατηγορία 6.1	Χλωρομυρμηκικού ισοπροπυλεστέρα	    ", "")
clv2.AddTextItem("2409	Κατηγορία 3	Ισοπροπυλική προπιονικό	    ", "")
clv2.AddTextItem("2410	Κατηγορία 3	Κατηγορία 1,Κατηγορία 2,Κατηγορία 3,Κατηγορία 6-τετραϋδροπυριδίνη	    ", "")
clv2.AddTextItem("2411	Κατηγορία 3	Βουτυρονιτρίλιου	    ", "")
clv2.AddTextItem("2412	Κατηγορία 3	Τετραϋδροθειοφαίνη	    ", "")
clv2.AddTextItem("2413	Κατηγορία 3	Tetrapropylorthotitanate	   SΘειοφαίνιο	    ", "")
clv2.AddTextItem("2416	Κατηγορία 3	Βορικού τριμεθυλίου	    ", "")
clv2.AddTextItem("2417	Κατηγορία 2	Carbonyl fluoride , συμπιεσμένο	    ", "")
clv2.AddTextItem("2418	Κατηγορία 2	Θείο τετραφθοριούχος	    ", "")
clv2.AddTextItem("2419	Κατηγορία 2	Bromotrifluoroethylene	    ", "")
clv2.AddTextItem("2420	Κατηγορία 2	Εξαφθοροακετόνης	    ", "")
clv2.AddTextItem("2421	Κατηγορία 2	Άζωτο τριοξείδιο	    ", "")
clv2.AddTextItem("2422	Κατηγορία 2	Octafluorobut-Κατηγορία 2-ένιο ή ψυκτικό αέριο R 1318	    ", "")
clv2.AddTextItem("2424	Κατηγορία 2	Οκταφθοροπροπανίου ή ψυκτικό αέριο R 218	    ", "")
clv2.AddTextItem("2426	Κατηγορία 5.1	Νιτρικό αμμώνιο , υγρό (θερμό συμπυκνωμένο διάλυμα)	    ", "")
clv2.AddTextItem("2427	Κατηγορία 5.1	Χλωρικό κάλιο , υδατικό διάλυμα	    ", "")
clv2.AddTextItem("2428	Κατηγορία 5.1	Χλωρικό νάτριο , υδατικό διάλυμα	    ", "")
clv2.AddTextItem("2429	Κατηγορία 5.1	Ασβέστιο χλωρικό υδατικό διάλυμα	    ", "")
clv2.AddTextItem("2430	Κατηγορία 8	Αλκυλοφαινόλες , στερεές, ε.α.ο. (συμπεριλαμβανομένων C2-C12 ομολόγων)	    ", "")
clv2.AddTextItem("2431	Κατηγορία 6.1	Ανισιδίνες	    ", "")
clv2.AddTextItem("2432	Κατηγορία 6.1	Ν, Ν-διαιθυλανιλίνη	    ", "")
clv2.AddTextItem("2433	Κατηγορία 6.1	Chloronitrotoluenes υγρά ή στερεά Chloronitrotoluenes	    ", "")
clv2.AddTextItem("2434	Κατηγορία 8	Dibenzyldichlorosilane	    ", "")
clv2.AddTextItem("2435	Κατηγορία 8	Ethylphenyldichlorosilane	    ", "")
clv2.AddTextItem("2436	Κατηγορία 3	Θειοξικό οξύ	    ", "")
clv2.AddTextItem("2437	Κατηγορία 8	Methylphenyldichlorosilane	    ", "")
clv2.AddTextItem("2438	Κατηγορία 6.1	Τριμεθυλακετυλοχλωρίδιο	    ", "")
clv2.AddTextItem("2439	Κατηγορία 8	Hydrogendifluoride νατρίου , στερεό ή νάτριο hydrogendifluoride ", "")
clv2.AddTextItem("2440	Κατηγορία 8	Χλωριούχου κασσιτέρου , πενταϋδρίτη	    ", "")
clv2.AddTextItem("2441	Κατηγορία 4.2	Τριχλωριούχο τιτάνιο , πυροφορικό ή μείγματα τριχλωριούχου τιτανίου, πυροφορικά ", "")   
clv2.AddTextItem("2442	Κατηγορία 8	Τριχλωρακετυλοχλωρίδιο	    ", "")
clv2.AddTextItem("2443	Κατηγορία 8	Οξυτριχλωριούχο βανάδιο	    ", "")
clv2.AddTextItem("2444	Κατηγορία 8	Βαναδίου τετραχλωριούχου	    ", "")
clv2.AddTextItem("2445	Κατηγορία 4.2	Αλκύλια λιθίου	    ", "")
clv2.AddTextItem("2446	Κατηγορία 6.1	Νιτροκρεσόλες	    ", "")
clv2.AddTextItem("2447	Κατηγορία 4.2	Λευκού φωσφόρου , λιωμένο	    ", "")
clv2.AddTextItem("2448	Κατηγορία 4.1	Θείο , λιωμένο	    ", "")
clv2.AddTextItem("2451	Κατηγορία 2	Τριφθοριούχο άζωτο , συμπιεσμένο	    ", "")
clv2.AddTextItem("2452	Κατηγορία 2	Αιθυλακετυλενίου , αναστέλλεται	    ", "")
clv2.AddTextItem("2453	Κατηγορία 2	Αιθυλική φθορίου ή ψυκτικό αέριο R 161	    ", "")
clv2.AddTextItem("2454	Κατηγορία 2	Φθοριούχο μεθύλιο , ή ψυκτικό αέριο R 41	    ", "")
clv2.AddTextItem("2456	Κατηγορία 3	Κατηγορία 2-χλωροπροπένιο	    ", "")
clv2.AddTextItem("2457	Κατηγορία 3	Κατηγορία 2,Κατηγορία 3 διμεθυλοβουτάνιου	    ", "")
clv2.AddTextItem("2458	Κατηγορία 3	Εξαδιένια	    ", "")
clv2.AddTextItem("2459	Κατηγορία 3	Κατηγορία 2-μεθυλ-Κατηγορία 1-βουτένιο	    ", "")
clv2.AddTextItem("2460	Κατηγορία 3	Κατηγορία 2-μεθυλ-Κατηγορία 2-βουτένιο	    ", "")
clv2.AddTextItem("2461	Κατηγορία 3	Methylpentadienes	    ", "")
clv2.AddTextItem("2463	Κατηγορία 4.3	Υδρίδιο αργιλίου	    ", "")
clv2.AddTextItem("2464	Κατηγορία 5.1	Νιτρικό βηρύλλιο	    ", "")
clv2.AddTextItem("2465	Κατηγορία 5.1	Διχλωροϊσοκυανουρικού οξέος , άλατα ξηρό ή διχλωροϊσοκυανουρικού οξέος	    ", "")
clv2.AddTextItem("2466	Κατηγορία 5.1	Υπεροξειδίου καλίου	    ", "")
clv2.AddTextItem("2468	Κατηγορία 5.1	Τριχλωροϊσοκυανουρικό οξύ , ξηρό	    ", "")
clv2.AddTextItem("2469	Κατηγορία 5.1	Βρωμικό ψευδαργύρου	    ", "")
clv2.AddTextItem("2470	Κατηγορία 6.1	Φαινυλακετονιτρίλιο , υγρό	    ", "")
clv2.AddTextItem("2471	Κατηγορία 6.1	Τετροξείδιο  οσμίου	    ", "")
clv2.AddTextItem("2473	Κατηγορία 6.1	Arsanilate νάτριο	    ", "")
clv2.AddTextItem("2474	Κατηγορία 6.1	Θειοφωσγένιον	    ", "")
clv2.AddTextItem("2475	Κατηγορία 8	Τριχλωριούχου βαναδίου	    ", "")
clv2.AddTextItem("2477	Κατηγορία 6.1	Ισοθειοκυανικού μεθυλεστέρα	    ", "")
clv2.AddTextItem("2478	Κατηγορία 3	Ισοκυανικά , εύφλεκτα, τοξικά    ", "")
clv2.AddTextItem("2480	Κατηγορία 6.1	Ισοκυανικό μεθύλιο	    ", "")
clv2.AddTextItem("2481	Κατηγορία 3	Ισοκυανικός αιθυλεστέρας	    ", "")
clv2.AddTextItem("2482	Κατηγορία 6.1	ισοκυανικό κ-Προπυλ	    ", "")
clv2.AddTextItem("2483	Κατηγορία 3	Ισοκυανικού ισοπροπυλεστέρα	    ", "")
clv2.AddTextItem("2484	Κατηγορία 6.1	ισοκυανικό τριτ-Βουτυλ	    ", "")
clv2.AddTextItem("2485	Κατηγορία 6.1	ισοκυανικού η-Βουτυλ	    ", "")
clv2.AddTextItem("2486	Κατηγορία 3	Ισοκυανικό Ισοβουτυλ	    ", "")
clv2.AddTextItem("2487	Κατηγορία 6.1	Ισοκυανικό φαινυλεστέρα	    ", "")
clv2.AddTextItem("2488	Κατηγορία 6.1	Ισοκυανικό κυκλοεξυλεστέρα	    ", "")
clv2.AddTextItem("2490	Κατηγορία 6.1	Dichlorodisopropyl αιθέρα	    ", "")
clv2.AddTextItem("2491	Κατηγορία 8	Αιθανολαμίνη ή αιθανολαμίνη  ", "")
clv2.AddTextItem("2493	Κατηγορία 3	Εξαμεθυλενιμίνης	     ", "")
clv2.AddTextItem("2495	Κατηγορία 5.1	Ιώδιο πενταφθοριούχο	 ", "")   
clv2.AddTextItem("2496	Κατηγορία 8	Προπιονικού ανυδρίτη	 ", "")   
clv2.AddTextItem("2498	Κατηγορία 3	Κατηγορία 1,Κατηγορία 2,Κατηγορία 3,Κατηγορία 6-Tetrahydrobenzaldehyde	 ", "")

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



