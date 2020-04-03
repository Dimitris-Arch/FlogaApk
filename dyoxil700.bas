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

 
clv2.AddTextItem("2601	Κατηγορία 2	Κυκλοβουτανο	   " ,"")
clv2.AddTextItem("2602	Κατηγορία 2	Διχλωροδιφθοριομεθάνιο και διφθοροαιθανίου   " ,"")
clv2.AddTextItem("2603	Κατηγορία 3	Κυκλοεπτατριενο	    " ,"")
clv2.AddTextItem("2604	Κατηγορία 8	Τριφθοριούχο βόριο αιθερικός διαιθυλεστέρας	    " ,"")
clv2.AddTextItem("2605	Κατηγορία 3	Ισοκυανικό Μεθοξυμεθυλο	  " ,"")
clv2.AddTextItem("2606	Κατηγορία 6.1	Μεθυλο ορθοπυριτικό	    " ,"")
clv2.AddTextItem("2607	Κατηγορία 3	Ακρολείνη διμερές , σταθεροποιημένο	    " ,"")
clv2.AddTextItem("2608	Κατηγορία 3	Nitropropanes	    " ,"")
clv2.AddTextItem("2609	Κατηγορία 6.1	Τριαλλυλ βορικό	    " ,"")
clv2.AddTextItem("2610	Κατηγορία 3	Τριαλλυλαμίνη	    " ,"")
clv2.AddTextItem("2611	Κατηγορία 6.1	Προπυλενοχλωρυδρίνη	    " ,"")
clv2.AddTextItem("2612	Κατηγορία 3	Μεθυλ προπυλαιθέρα	    " ,"")
clv2.AddTextItem("2614	Κατηγορία 3	Μεθαλλυλο αλκοόλ	    " ,"")
clv2.AddTextItem("2615	Κατηγορία 3	Αιθυλ προπυλ αιθέρας	   " ,"") 
clv2.AddTextItem("2616	Κατηγορία 3	Τριισοπροπυλ βορικό	    " ,"")
clv2.AddTextItem("2617	Κατηγορία 3	Methylcyclohexanols , εύφλεκτο	   " ,"") 
clv2.AddTextItem("2618	Κατηγορία 3	Vinyltoluenes , αναστέλλεται	    " ,"")
clv2.AddTextItem("2619	Κατηγορία 8	Βενζυλδιμεθυλαμίνη	    " ,"")
clv2.AddTextItem("2620	Κατηγορία 3	Βουτυρικοί Αμυλεστέρας	 " ,"")   
clv2.AddTextItem("2621	Κατηγορία 3	Ακετυλο μεθυλο-καρβινόλη	 " ,"")   
clv2.AddTextItem("2622	Κατηγορία 3	Glycidaldehyde " ,"")	   
clv2.AddTextItem("2623	Κατηγορία 4.1	Προσανάμματα , στερεά με εύφλεκτο υγρό " ,"")	   
clv2.AddTextItem("2624	Κατηγορία 4.3	Πυριτιούχο μαγνήσιο " ,"")	   
clv2.AddTextItem("2626	Κατηγορία 5.1	Οξύ χλωρικό υδατικό διάλυμα, με όχι περισσότερο από 10 τοις εκατό χλωρικό οξύ	    " ,"")
clv2.AddTextItem("2627	Κατηγορία 5.1	Νιτρώδη , ανόργανα, ε.α.ο.	    " ,"")
clv2.AddTextItem("2628	Κατηγορία 6.1	Φθοριοοξικού κάλιο	    " ,"")
clv2.AddTextItem("2629	Κατηγορία 6.1	Φθοριοοξικού νάτριο	 " ,"")   
clv2.AddTextItem("2630	Κατηγορία 6.1	Σεληνικ ή Σεληνιώδες " ,"")	   
clv2.AddTextItem("2642	Κατηγορία 6.1	Φθοραιθανικό οξύ	    " ,"")
clv2.AddTextItem("2643	Κατηγορία 6.1	Βρωμοοξεικό	    " ,"")
clv2.AddTextItem("2644	Κατηγορία 6.1	Ιωδιούχο μεθύλιο	    " ,"")
clv2.AddTextItem("2645	Κατηγορία 6.1	Φαινακυλοβρωμίδιο	    " ,"")
clv2.AddTextItem("2646	Κατηγορία 6.1	Εξαχλωροκυκλοπενταδιενίου	   " ,"")
clv2.AddTextItem("2647	Κατηγορία 6.1	Μηλονονιτρίλιο	    " ,"")
clv2.AddTextItem("2648	Κατηγορία 6.1	Dibromobutan	    " ,"")
clv2.AddTextItem("2649	Κατηγορία 6.1	Διχλωροακετόνη	 " ,"")   
clv2.AddTextItem("2650	Κατηγορία 6.1	Κατηγορία 1,Κατηγορία 1-διχλωρο-Κατηγορία 1-νιτροαιθάνιο", "")	   
clv2.AddTextItem("2651	Κατηγορία 6.1	Κατηγορία 4,4'-Διαμινοδιφαινυλομεθάνιο	  ", "") 
clv2.AddTextItem("2653	Κατηγορία 6.1	Ιωδιούχο Βενζυλική	   ", "")
clv2.AddTextItem("2655	Κατηγορία 6.1	Φθοριοπυρι κάλιο	", "")  
clv2.AddTextItem("2656	Κατηγορία 6.1	Κινολίνης	   ", "")
clv2.AddTextItem("2657	Κατηγορία 6.1	Το σελήνιο δισουλφιδίου	   ", "")
clv2.AddTextItem("2659	Κατηγορία 6.1	Χλωροακετικό νάτριο	   ", "")
clv2.AddTextItem("2660	Κατηγορία 6.1	Nitrotoluidines (μονο)	  ", "") 
clv2.AddTextItem("2661	Κατηγορία 6.1	Εξαχλωροακετόνη	   ", "")
clv2.AddTextItem("2662	Κατηγορία 6.1	Υδροκινόνη	   ", "")
clv2.AddTextItem("2664	Κατηγορία 6.1	Διβρωμιομεθανίου	  ", "") 
clv2.AddTextItem("2667	Κατηγορία 6.1	Butyltoluenes	   ", "")
clv2.AddTextItem("2668	Κατηγορία 6.1	Χλωριοακετονιτρίλιο	   ", "")
clv2.AddTextItem("2669	Κατηγορία 6.1	Chlorocresols , υγρό ή Chlorocresols, στερεά	", "")   
clv2.AddTextItem("2670	Κατηγορία 8	Το κυανιούχο χλώριο	   ", "")
clv2.AddTextItem("2671	Κατηγορία 6.1	Αμινοπυριδίναι ", "") 
clv2.AddTextItem("2672	Κατηγορία 8	Αμμωνία διάλυμα", "")
clv2.AddTextItem("2673	Κατηγορία 6.1	Κατηγορία 2-αμινο-Κατηγορία 4-χλωροφαινόλη	   ", "")
clv2.AddTextItem("2674	Κατηγορία 6.1	Φθοροπυριτικό νάτριο	  ", "") 
clv2.AddTextItem("2676	Κατηγορία 2	Stibine	 ", "")  
clv2.AddTextItem("2677	Κατηγορία 8	Υδροξείδιο  ρουβιδίου ", "")
clv2.AddTextItem("2678	Κατηγορία 8	Υδροξείδιο  ρουβιδίου	 ", "")  
clv2.AddTextItem("2679	Κατηγορία 8	Lithiumhydroxidl", "")
clv2.AddTextItem("2680	Κατηγορία 8	Υδροξείδιο  λιθίου , μονοένυδρο ή υδροξείδιο  λιθίου, στερεό	", "")   
clv2.AddTextItem("2681	Κατηγορία 8	Υδροξείδιο  καισίου λύση	 ", "")  
clv2.AddTextItem("2682	Κατηγορία 8	Υδροξείδιο  καισίου	   ", "")
clv2.AddTextItem("2683	Κατηγορία 8	Σουλφίδιο  αμμωνίου λύση	 ", "")  
clv2.AddTextItem("2684	Κατηγορία 3	Διαιθυλαμινοπροπυλαμίνη	   ", "")
clv2.AddTextItem("2685	Κατηγορία 8	Ν, Ν-διαιθυλαιθυλενοδιαμίνη	   ", "")
clv2.AddTextItem("2686	Κατηγορία 8	Κατηγορία 2-διαιθυλαμινοαιθανόλης	  ", "") 
clv2.AddTextItem("2687	Κατηγορία 4.1	Νιτρικό δικυκλοεξυλαμμωνίου	   ", "")
clv2.AddTextItem("2688	Κατηγορία 6.1	1χλωρο-βρωμοπροπάνιο	 ", "")  
clv2.AddTextItem("2689	Κατηγορία 6.1	Γλυκερόλη άλφα-monochlorohydrin	   ", "")
clv2.AddTextItem("2690	Κατηγορία 6.1	Νη-Βουτυλ ιμιδαζόλη	   ", "")
clv2.AddTextItem("2691	Κατηγορία 8	Πενταβρωμιούχο φωσφόρο	   ", "")
clv2.AddTextItem("2692	Κατηγορία 8	Τριβρωμιούχο βόριο	   ", "")
clv2.AddTextItem("2693	Κατηγορία 8	Διθειώδη , υδατικά διαλύματα, nos	  ", "") 
clv2.AddTextItem("2698	Κατηγορία 8	Τετραϋδροφθαλικό ανυδρίτες με περισσότερο από 0,05 τοις εκατό  μηλεϊνικού ανυδρίτη	", "")   
clv2.AddTextItem("2699	Κατηγορία 8	Τριφθοροξικό οξύ	", "") 

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




