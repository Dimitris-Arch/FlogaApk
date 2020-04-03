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

 
clv2.AddTextItem("0401	Κατηγορία 1.1	Διπικρύλιο σουλφίδιο , ξηρός ή νωπός με λιγότερο από 10 τοις εκατό νερό, κατά βάρος	      " ,"")
clv2.AddTextItem("0402	Κατηγορία 1.1	Υπερχλωρικό αμμώνιο	      " ,"")
clv2.AddTextItem("0403	 Κατηγορία 3	Φωτοβολίδες , εναέρια	      " ,"")
clv2.AddTextItem("04	 Κατηγορία 4	Φωτοβολίδες , εναέρια	      " ,"")
clv2.AddTextItem("0405	 Κατηγορία 4	Φυσίγγια , σήμα	      " ,"")
clv2.AddTextItem("0406	 Κατηγορία 1.3	Δινιτροζοβενζόλιο	      " ,"")
clv2.AddTextItem("0407	 Κατηγορία 1.4	Τετραζολοξικό οξύ	      " ,"")
clv2.AddTextItem("0408	Κατηγορία 1.1	Ασφάλειες, εκρηκτικές, με προστατευτικά χαρακτηριστικά	   " ,"")   
clv2.AddTextItem("0409	 Κατηγορία 1.3	Ασφάλειες, εκρηκτικές, με προστατευτικά χαρακτηριστικά	   " ,"")   
clv2.AddTextItem("0410	 Κατηγορία 1.4	Ασφάλειες, εκρηκτικές, με προστατευτικά χαρακτηριστικά	    " ,"")  
clv2.AddTextItem("0411	 Κατηγορία 1.1	Τετρανιτρικού (τετρανιτρικό Πενταερυθριτόλη), με όχι λιγότερο από 7 τοις εκατό κατά μάζα κερί   " ,"")	   
clv2.AddTextItem("0412	 Κατηγορία 1.4	ΦΥΣΙΓΓΙΑ ΓΙΑ ΟΠΛΑ, με εκρηκτική γόμωση	      " ,"")
clv2.AddTextItem("0413	 Κατηγορία 1.2	Φυσίγγια για όπλα, κενό	      " ,"")
clv2.AddTextItem("0414	 Κατηγορία 1.2	Χρεώσεις, πρόωσης για κανόνια	     " ,"") 
clv2.AddTextItem("0415	 Κατηγορία 1.2	Χρεώσεις, προωθητική	      " ,"")
clv2.AddTextItem("0417	 Κατηγορία 1.3	Φυσίγγια για όπλα, αδρανούς βλήματος ή Φυσίγγια, μικρών όπλων	   " ,"")   
clv2.AddTextItem("0418	 Κατηγορία 1.1	Φωτοβολίδες, επιφάνεια	      " ,"")
clv2.AddTextItem("0419	 Κατηγορία 2.3	Φωτοβολίδες, επιφάνεια	      " ,"")
clv2.AddTextItem("0420	 Κατηγορία 1.1	Φωτοβολίδες, εναέρια	      " ,"")
clv2.AddTextItem("0421	 Κατηγορία 2.3	Φωτοβολίδες, εναέρια	      " ,"")
clv2.AddTextItem("0424	 Κατηγορία 3	Βλήματα, αδρανή με ιχνηθέτη	      " ,"")
clv2.AddTextItem("0425	 Κατηγορία 3	Βλήματα, αδρανή με ιχνηθέτη	      " ,"")
clv2.AddTextItem("0426	 Κατηγορία 4	ΒΛΗΜΑΤΑ, με διαρρήκτη ή διαρροή γόμωσης	     " ,"") 
clv2.AddTextItem("0427	 Κατηγορία 1.4	ΒΛΗΜΑΤΑ, με διαρρήκτη ή διαρροή γόμωσης	      " ,"")
clv2.AddTextItem("0428	 Κατηγορία 1.1	Τα άρθρα, τα είδη πυροτεχνίας για τεχνικούς σκοπούς	   " ,"")   
clv2.AddTextItem("0429	 Κατηγορία  2.3	Τα άρθρα, τα είδη πυροτεχνίας για τεχνικούς σκοπούς	   " ,"")   
clv2.AddTextItem("0430	 Κατηγορία 3	Τα άρθρα, τα είδη πυροτεχνίας για τεχνικούς σκοπούς	   " ,"")   
clv2.AddTextItem("0431	 Κατηγορία 3	Τα άρθρα, τα είδη πυροτεχνίας για τεχνικούς σκοπούς	   " ,"")   
clv2.AddTextItem("0432	 Κατηγορία 4	Τα άρθρα, τα είδη πυροτεχνίας για τεχνικούς σκοπούς	   " ,"")   
clv2.AddTextItem("0433	 Κατηγορία 1.1	Κέικ σε σκόνη (πάστα σε σκόνη), βρεγμένη με όχι λιγότερο από 17 τοις εκατό αλκοόλης κατά μάζα	   " ,"")   
clv2.AddTextItem("0434	 Κατηγορία 2.3	ΒΛΗΜΑΤΑ, με διαρρήκτη ή διαρροή γόμωσης	      " ,"")
clv2.AddTextItem("0435	 Κατηγορία 3	ΒΛΗΜΑΤΑ, με διαρρήκτη ή διαρροή γόμωσης	      " ,"")
clv2.AddTextItem("0436	 Κατηγορία 1.2	Ρουκετες, με διαρροή γόμωσης	      " ,"")
clv2.AddTextItem("0437	 Κατηγορία 1.3	Ρουκετες, με διαρροή γόμωσης	      " ,"")
clv2.AddTextItem("0438	 Κατηγορία 1.4	Ρουκετες, με διαρροή γόμωσης	      " ,"")
clv2.AddTextItem("0446	 Κατηγορία 1.4	Θήκες, εύφλεκτες, κενές, χωρίς αστάρι	     " ,"") 
clv2.AddTextItem("0447	 Κατηγορία 1.3	Θήκες, εύφλεκτες, κενές, χωρίς αστάρι	      " ,"")
clv2.AddTextItem("0448	 Κατηγορία 1.4	Mercaptotetrazol- οξικό οξύ	   " ,"")   
clv2.AddTextItem("0449	 Κατηγορία 1.1	Τορπίλες , υγρό τροφοδοτείται, με ή χωρίς εκρηκτική γόμωση	     " ,"") 
clv2.AddTextItem("0450	 Κατηγορία 1.3	Τορπίλες, υγρό τσέπης, με αδρανή κεφαλή	      " ,"")
clv2.AddTextItem("0451	Κατηγορία 1.1	Τορπίλες με εκρηκτική γόμωση	      " ,"")
clv2.AddTextItem("0452	 Κατηγορία 3	Χειροβομβίδες , πρακτική, χειρός ή όπλου	    " ,"")  
clv2.AddTextItem("0453	 Κατηγορία 3	Πύραυλοι , γραμμή ρίψης	      " ,"")
clv2.AddTextItem("0454	 Κατηγορία 4	Αναφλεκτηρες	      " ,"")
clv2.AddTextItem("0455	 Κατηγορία 4	Πυροκροτητές , μη ηλεκτρικά, για ανατινάξεις	      " ,"")
clv2.AddTextItem("0456	 Κατηγορία 4	Πυροκροτητές, ΗΛΕΚΤΡΙΚΟΙ, για ανατινάξεις	    " ,"")  	   
clv2.AddTextItem("0461	 Κατηγορία 1.1	Εξαρτήματα, εκρηκτικών, NOS	      " ,"")
clv2.AddTextItem("0462	 Κατηγορία 1.1	Άρθρα, εκρηκτικά, NOS	      " ,"")
clv2.AddTextItem("0463	Κατηγορία 1.1	Άρθρα, εκρηκτικά, NOS	      " ,"")
clv2.AddTextItem("0464	Κατηγορία 1.1	Άρθρα, εκρηκτικά, NOS	      " ,"")
clv2.AddTextItem("0465	 Κατηγορία 1.1	Άρθρα, εκρηκτικά, NOS	      " ,"")
clv2.AddTextItem("0466	 Κατηγορία 1.2	Άρθρα, εκρηκτικά, NOS	      " ,"")
clv2.AddTextItem("0467	 Κατηγορία 1.2	Άρθρα, εκρηκτικά, NOS	      " ,"")
clv2.AddTextItem("0468	 Κατηγορία 1.2	Άρθρα, εκρηκτικά, NOS	      " ,"")
clv2.AddTextItem("0469	 Κατηγορία 4	Άρθρα, εκρηκτικά, NOS	      " ,"")
clv2.AddTextItem("0470	 Κατηγορία 1.3	Άρθρα, εκρηκτικά, NOS	      " ,"")
clv2.AddTextItem("0471	 Κατηγορία 1.4	Άρθρα, εκρηκτικά, NOS	   " ,"")     
clv2.AddTextItem("0472	 Κατηγορία 1.4	Άρθρα, εκρηκτικά, NOS	      " ,"")
clv2.AddTextItem("0473	 Κατηγορία 1.1	Ουσίες, εκρηκτικά, NOS	      " ,"")
clv2.AddTextItem("0474	 Κατηγορία 1.1	Ουσίες, εκρηκτικά, NOS	      " ,"")
clv2.AddTextItem("0475	Κατηγορία 1.1	Ουσίες, εκρηκτικά, NOS	      " ,"")
clv2.AddTextItem("0476	 Κατηγορία 1.1	Ουσίες, εκρηκτικά, NOS	      " ,"")
clv2.AddTextItem("0477	 Κατηγορία 1.3	Ουσίες, εκρηκτικά, NOS	      " ,"")
clv2.AddTextItem("0478	 Κατηγορία 3	Ουσίες, εκρηκτικά, NOS	      " ,"")
clv2.AddTextItem("0479	 Κατηγορία 1.4	Ουσίες, εκρηκτικά, NOS	      " ,"")
clv2.AddTextItem("0480	 Κατηγορία 1.4	Ουσίες, εκρηκτικά, NOS	      " ,"")
clv2.AddTextItem("0481	 Κατηγορία 4	Ουσίες, εκρηκτικά, NOS	      " ,"")
clv2.AddTextItem("0482	 Κατηγορία 1.5	Ουσίες, εκρηκτική, πολύ ευαίσθητο (Ουσίες, EVI), NOS	   " ,"")   
clv2.AddTextItem("0483	Κατηγορία 1.1	Κυκλοτριμεθυλενοτρινιτραμίνη (Cyclonite? κυκλονίτης? RDX), απευαισθητοποιημένοι	   " ,"")   
clv2.AddTextItem("0484	Κατηγορία 1.1	Cyclotetramethylenetetranitramine (Octogen? HMX ), απευαισθητοποιημένοι	      " ,"")
clv2.AddTextItem("0485	 Κατηγορία 3	Ουσίες, εκρηκτικά, NOS	      " ,"")
clv2.AddTextItem("0486	 Κατηγορία 1.6 	Άρθρα, εκρηκτικά, εξαιρετικά μη-ευαίσθητες (άρθρα, ΕΕΙ)	      " ,"")
clv2.AddTextItem("0487	 Κατηγορία 3	Σήματα, καπνός	      " ,"")
clv2.AddTextItem("0488	 Κατηγορία 3	Πυρομαχικά, πρακτική	       " ,"")
clv2.AddTextItem("0489	Κατηγορία 1.1	Dinitroglycoluril (Dingu)	      " ,"")
clv2.AddTextItem("0490	Κατηγορία 1.1	Nitrotriazolone (ΕΟΜ)	      " ,"")
clv2.AddTextItem("0491	 Κατηγορία 1.4	Χρεώσεις, προωθητική	      " ,"")
clv2.AddTextItem("0492	 Κατηγορία 3	Σήματα, σιδηροδρομικών γραμμών, εκρηκτικά	    " ,"")  
clv2.AddTextItem("0493	 Κατηγορία 3	Σήματα, σιδηροδρομικών γραμμών, εκρηκτικά	      " ,"")
clv2.AddTextItem("0494	 Κατηγορία 1.4	Jet , διάτρηση όπλα, χρεώνονται, αλλά και το πετρέλαιο, χωρίς πυροκροτητή	   " ,"")   
clv2.AddTextItem("0495	 Κατηγορία 1.3	Προωθητική , υγρό	      " ,"")
clv2.AddTextItem("0496	Κατηγορία 1.1	ΟΚΤΟΝΑΛΗ   " ,"")	   
clv2.AddTextItem("0497	 Κατηγορία 1.1	Προωθητική, υγρό	      " ,"")
clv2.AddTextItem("0498	 Κατηγορία 1.1	Προωθητική, στερεά	      " ,"")
clv2.AddTextItem("0499	 Κατηγορία 1.3	Προωθητική, στερεά	      " ,"")
clv2.AddTextItem("0500	 Κατηγορία 4	Συνδεσμολογίες πυροκροτητών, μη ηλεκτρικές, για ανατινάξεις	    " ,"")

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
