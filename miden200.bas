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

 
clv2.AddTextItem("0101	 Κατηγορία 1	Fuse , μη-εκρηκτικό (στιγμιαία ή quickmatch)	   " ,"")
clv2.AddTextItem("0102	 Κατηγορία 1	Καλώδιο εκρηκτικού ή Fuse εκρηκτικό μέταλλα επιστρωμένα	     " ,"")
clv2.AddTextItem("0103	 Κατηγορία 1	Fuse, Αναφλεκτήρας σωληνοειδές μέταλλα επιστρωμένα	      " ,"")
clv2.AddTextItem("0104	 Κατηγορία 1	ΚΑΛΩΔΙΟ, ΕΚΡΗΚΤΙΚΟ, ήπια επίδραση ή η ασφάλεια, έκρηξη, ήπια επίδραση μέταλλα επιστρωμένα	   " ,"")   
clv2.AddTextItem("0105	 Κατηγορία 1	Ασφάλεια, ασφάλεια	      " ,"")
clv2.AddTextItem("0106 	 Κατηγορία 1	Ασφάλειες, εκρηκτικών	      " ,"")
clv2.AddTextItem("0110	 Κατηγορία 1	Χειροβομβίδες , πρακτική, χειρός ή όπλου	   " ,"")   
clv2.AddTextItem("0113	 Κατηγορία 1	Γουανυλ nitrosaminoguanylidene υδραζίνης , βρεγμένο με όχι λιγότερο από 30 τοις εκατό νερό κατά μάζα	      " ,"")
clv2.AddTextItem("0114	 Κατηγορία 1	Γουανυλ nitrosaminoguanyltetrazene    " ,"")
clv2.AddTextItem("0118	 Κατηγορία 1	ΕΞΟΛΙΤΗΣ , ή ΕΞΠΤΟΛΗ ξηρός ή νωπός με λιγότερο από 15 τοις εκατό νερό κατά μάζα	   " ,"")   
clv2.AddTextItem("0121	 Κατηγορία 1	Αναφλεκτηρες	      " ,"")
clv2.AddTextItem("0124	 Κατηγορία 1	Jet , διάτρηση όπλα, χρεώνεται το πετρέλαιο καλά, με / χωρίς πυροκροτητή   " ,"")	   
clv2.AddTextItem("0129	 Κατηγορία 1	Αζίδιο  μολύβδου , ??βρεγμένο με όχι λιγότερο από 20 τοις εκατό νερό ή μίγμα αλκοόλης και νερού, κατά βάρος	   " ,"")   
clv2.AddTextItem("0130	 Κατηγορία 1	Στυφνικός μόλυβδος , νωπό ή στυφνικού, βρεγμένο με όχι λιγότερο από 20	      " ,"")
clv2.AddTextItem("0131	 Κατηγορία 1	Αναπτήρες   " ,"")
clv2.AddTextItem("0132	 Κατηγορία 1	Αναφλεγόμενη μεταλλικά άλατα των αρωματικών νιτροπαραγώγων, ε.α.ο.	      " ,"")
clv2.AddTextItem("0133	 Κατηγορία 1	Εξανιτρική μανιτόλη   " ,"")
clv2.AddTextItem("0135	 Κατηγορία 1	Υδράργυρος κεραυνοβολώ , βρεγμένο με όχι λιγότερο από 20 τοις εκατό νερό, ή ένα μίγμα αλκοόλης και νερού, κατά βάρος	   " ,"")   
clv2.AddTextItem("0136 	 Κατηγορία 1	Μεταλλεία με εκρηκτική γόμωση	      " ,"")
clv2.AddTextItem("0143	 Κατηγορία 1	Νιτρογλυκερίνη   " ,"")
clv2.AddTextItem("0144	 Κατηγορία 1	Νιτρογλυκερίνη, διάλυμα σε αλκοόλη   " ,"")
clv2.AddTextItem("0146	 Κατηγορία 1	Nitrostarch , ξηρός ή νωπός με λιγότερο από 20 τοις εκατό νερό κατά μάζα   " ,"")	   
clv2.AddTextItem("0147	 Κατηγορία 1	Nitro ουρία	      " ,"")
clv2.AddTextItem("0150	 Κατηγορία 1	Τετρανιτρικού, νωπό ή Πενταερυθρίτης τετρανιτρική    " ,"")  
clv2.AddTextItem("0151	 Κατηγορία 1	ΠΕΝΤΟΛΙΤΗΣ , ξηρός ή νωπός με λιγότερο από 15 τοις εκατό νερό κατά μάζα   " ,"")	   
clv2.AddTextItem("0153	 Κατηγορία 1	Trinitroaniline ή Picramide	      " ,"")
clv2.AddTextItem("0154	 Κατηγορία 1	Τρινιτροφαινόλης ή πικρικό οξύ, ξηρός ή νωπός με λιγότερο από 30 τοις εκατό νερό κατά μάζα	      " ,"")
clv2.AddTextItem("0155	 Κατηγορία 1	Τρινιτροχλωροβενζόλιο ή πικρυλοχλωρίδιο	      " ,"")
clv2.AddTextItem("0159	 Κατηγορία 1	Κέικ σε σκόνη, νωπό ή πάστα σε σκόνη, βρεγμένο με όχι λιγότερο από 25 τοις εκατό νερό κατά μάζα   " ,"")	
clv2.AddTextItem("0160 	 Κατηγορία 1	Σκόνη , άκαπνη	      " ,"")
clv2.AddTextItem("0167   Κατηγορία 1	Βλήματα , με εκρηκτική γόμωση	      " ,"")
clv2.AddTextItem("0171	 Κατηγορία 1	Πυρομαχικά , φωτίζοντας με ή χωρίς ρήγμα, διαρροή γόμωσης ή προωθητικής γόμωσης   " ,"")	   
clv2.AddTextItem("0173	 Κατηγορία 1	Συσκευές απελευθέρωσης, εκρηκτικά	      " ,"")
clv2.AddTextItem("0174	 Κατηγορία 1	Πριτσίνια , εκρηκτικά	      " ,"")
clv2.AddTextItem("0180 	 Κατηγορία 1	Ρόκετς, με εκρηκτική γόμωση	      " ,"")
clv2.AddTextItem("0183	 Κατηγορία 1	Ρόκετς , με αδρανή κεφαλή	      " ,"")
clv2.AddTextItem("0186	 Κατηγορία 1	Πυραυλοκινητήρες	   " ,"")
clv2.AddTextItem("0190	 Κατηγορία 1	Δείγματα, εκρηκτικά, πλην έναρξη εκρηκτικά" ,"")
 clv2.AddTextItem("0191	 Κατηγορία 1	Συσκευές σηματοδότησης, χέρι" ,"")
 clv2.AddTextItem("0192 	 Κατηγορία 1	Σήματα, σιδηροδρομικών γραμμών, εκρηκτικά" ,"")
 clv2.AddTextItem("0194 	 Κατηγορία 1	Σήματα, αγωνία, πλοίο" ,"")
 clv2.AddTextItem("0196 	 Κατηγορία 1	Σήματα, καπνός" ,"")


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
