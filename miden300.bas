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

 
clv2.AddTextItem("0204	 Κατηγορία 1	Υγροδείκτες , εκρηκτικά	"  ,"")   
clv2.AddTextItem("0207	 Κατηγορία 1	Τετρανιτροανιλίνη	   "  ,"")   
clv2.AddTextItem("0208	 Κατηγορία 1	Trinitrophenylmethylnitramine ή τετρύλη	   "  ,"")   
clv2.AddTextItem("0209	 Κατηγορία 1	Τρινιτροτολουόλιο ή TNT, ξηρός ή νωπός με λιγότερο από 30 τοις εκατό νερό κατά μάζα	"  ,"")      
clv2.AddTextItem("0212	 Κατηγορία 1	Ιχνηλάτες για τα πυρομαχικά	   "  ,"")   
clv2.AddTextItem("0213	 Κατηγορία 1	Trinitroanisole	   "  ,"")   
clv2.AddTextItem("0214	 Κατηγορία 1	Τρινιτροβενζόλιο , ξηρός ή νωπός με λιγότερο από 30 τοις εκατό νερό κατά μάζα	   "  ,"")   
clv2.AddTextItem("0214	 Κατηγορία 4	Trinitrobenzen, angefeuchtet mit mindestens 10 Masse-% Wasser	   "  ,"")   
clv2.AddTextItem("0215	 Κατηγορία 1	Τρινιτροβενζοϊκό οξύ , ξηρός ή νωπός με λιγότερο από 30 τοις εκατό νερό κατά μάζα	   "  ,"")   
clv2.AddTextItem("0216	 Κατηγορία 1	Τρινιτρο-μετα-κρεσόλη	   "  ,"")   
clv2.AddTextItem("0217	 Κατηγορία 1	Trinitronaphthalene	   "  ,"")   
clv2.AddTextItem("0218	 Κατηγορία 1	Trinitrophenetole	   "  ,"")   
clv2.AddTextItem("0219	 Κατηγορία 1	Trinitroresorcinol ή στυφνικό οξύ, ξηρός ή νωπός με λιγότερο από 20 τοις εκατό νερό, ή μείγμα αλκοόλης και νερού, κατά μάζα	   "  ,"")   
clv2.AddTextItem("0220	 Κατηγορία 1	Νιτρικό Ουρία , ξηρός ή νωπός με λιγότερο από 20 τοις εκατό νερό κατά μάζα	   "  ,"")   
clv2.AddTextItem("0221	 Κατηγορία 1	Κεφαλές , τορπίλη με εκρηκτική γόμωση	   "  ,"")   
clv2.AddTextItem("0224	 Κατηγορία 1	Αζίδιο  βαρίου , ξηρός ή νωπός με λιγότερο από 50 τοις εκατό νερό κατά μάζα	"  ,"")      
clv2.AddTextItem("0225	 Κατηγορία 1	Ενισχυτές με πυροκροτητή	   "  ,"")   
clv2.AddTextItem("0226	 Κατηγορία 1	Cyclotetramethylenetetranitramine, νωπό ή HMX	"  ,"")   
clv2.AddTextItem("0234	 Κατηγορία 1	Natriumdinitroorthocresolat , trocken oder angefeuchtet mit weniger ALS 15 Masse-% Wasser	   "  ,"")   
clv2.AddTextItem("0234	 Κατηγορία 4	Νάτριο δινιτρο-ο-κρεζολικό , ξηρός ή νωπός με λιγότερο από 15 τοις εκατό νερό κατά μάζα	   "  ,"")   
clv2.AddTextItem("0235	 Κατηγορία 1	Picramate νάτριο , ξηρός ή νωπός με λιγότερο από 20 τοις εκατό νερό κατά μάζα	   "  ,"")   
clv2.AddTextItem("0236	 Κατηγορία 1	Ζιρκόνιο picramate , ξηρός ή νωπός λιγότερο από 20 τοις εκατό νερό κατά μάζα	   "  ,"")   
clv2.AddTextItem("0237	 Κατηγορία 1	Χρεώσεις, σχήμα, ευέλικτο, γραμμική	   "  ,"")   
clv2.AddTextItem("0238 	 Κατηγορία 1	Πύραυλοι, γραμμή ρίψης	   "  ,"")   
clv2.AddTextItem("0241	 Κατηγορία 1	Εκρηκτικό, ανατινάξεις, τύπου Ε	   "  ,"")   
clv2.AddTextItem("0242	 Κατηγορία 1	Χρεώσεις, πρόωσης για κανόνια	   "  ,"")   
 clv2.AddTextItem("0243 	 Κατηγορία 1	Πυρομαχικά, εμπρηστικά, λευκού φωσφόρου, με ρήγμα, διαρροή γόμωσης ή προωθητικής γόμωσης"  ,"")   	   
clv2.AddTextItem("0245 	 Κατηγορία 1	Καπνού Πυρομαχικά, λευκού φωσφόρου με ρήγμα, διαρροή γόμωσης ή προωθητικής γόμωσης	   "  ,"")   
clv2.AddTextItem("0247	 Κατηγορία 1	Πυρομαχικά, εμπρηστικά υγρό ή γέλη, με ρήγμα, διαρροή γόμωσης ή προωθητικής γόμωσης	   "  ,"")   
clv2.AddTextItem("0248 	 Κατηγορία 1	Επινοήσεις, ενεργοποιείται με το νερό, με ρήγμα, διαρροή γόμωσης ή προωθητικής γόμωσης	   "  ,"")   
clv2.AddTextItem("0250	 Κατηγορία 1	Πυραυλοκινητήρες με υπεργολικών υγρών, με ή χωρίς διαρροή γόμωσης	   "  ,"")   
clv2.AddTextItem("0254	 Κατηγορία 1	Πυρομαχικά, φωτίζοντας με ή χωρίς ρήγμα, διαρροή γόμωσης ή προωθητικής γόμωσης	 "  ,"")     
clv2.AddTextItem("0255	 Κατηγορία 1	Πυροκροτητές, ΗΛΕΚΤΡΙΚΟΙ, για ανατινάξεις	   "  ,"")   
clv2.AddTextItem("0257	 Κατηγορία 1	Ασφάλειες, εκρηκτικών	   "  ,"")   
clv2.AddTextItem("0266	 Κατηγορία 1	ΟΚΤΟΛΙΤΗΣ ή ΟΚΤΟΛΗ, ξηρός ή νωπός με λιγότερο από 15 τοις εκατό νερό κατά μάζα	"  ,"")      
clv2.AddTextItem("0267	 Κατηγορία 1	Πυροκροτητές, μη ηλεκτρικά, για ανατινάξεις	   "  ,"")   
clv2.AddTextItem("0268	 Κατηγορία 1	Ενισχυτές με πυροκροτητή	   "  ,"")   
clv2.AddTextItem("0271 	 Κατηγορία 1	Χρεώσεις, προωθητική	   "  ,"")   
clv2.AddTextItem("0275 	 Κατηγορία 1	Φυσίγγια, συσκευή ηλεκτρικής ενέργειας	   "  ,"")   
clv2.AddTextItem("0277 	 Κατηγορία 1	Φυσίγγια, πετρελαιοπηγή	   "  ,"")   
clv2.AddTextItem("0279	 Κατηγορία 1	Χρεώσεις, πρόωσης για κανόνια	   "  ,"")   
clv2.AddTextItem("0280 	 Κατηγορία 1	Πυραυλοκινητήρες	   "  ,"")   
clv2.AddTextItem("0282	 Κατηγορία 1	Νιτρογουανιδίνη ή Picrite, ξηρός ή νωπός με λιγότερο από 20 τοις εκατό νερό κατά μάζα	   "  ,"")   
clv2.AddTextItem("0283	 Κατηγορία 1	Ενισχυτές, χωρίς πυροκροτητή	   "  ,"")   
clv2.AddTextItem("0284 	 Κατηγορία 1	Χειροβομβίδες, χειρός ή όπλου, με εκρηκτική γόμωση	   "  ,"")   
clv2.AddTextItem("0286	 Κατηγορία 1	Κεφαλές, ρόκα με εκρηκτική γόμωση	   "  ,"")   
clv2.AddTextItem("0288	 Κατηγορία 1	Χρεώσεις, σχήμα, ευέλικτο, γραμμική	   "  ,"")   
clv2.AddTextItem("0289	 Κατηγορία 1	ΚΑΛΩΔΙΟ, ΕΚΡΗΚΤΙΚΟ, εύκαμπτο	   "  ,"")   
clv2.AddTextItem("0290	 Κατηγορία 1	Καλώδιο, εκρηκτικού ή Fuse, εκρηκτικό μέταλλα επιστρωμένα	   "  ,"")   
clv2.AddTextItem("0291	 Κατηγορία 1	Βόμβες, με εκρηκτική γόμωση	   "  ,"")   
clv2.AddTextItem("0292 	 Κατηγορία 1	Χειροβομβίδες, χειρός ή όπλου, με εκρηκτική γόμωση	"  ,"")      
clv2.AddTextItem("0294	 Κατηγορία 1	Μεταλλεία με εκρηκτική γόμωση	   "  ,"")   
clv2.AddTextItem("0295	 Κατηγορία 1	Ρόκετς, με εκρηκτική γόμωση	   "  ,"")   
clv2.AddTextItem("0296	 Κατηγορία 1	Υγροδείκτες, εκρηκτικά	   "  ,"")   
clv2.AddTextItem("0297	 Κατηγορία 1	Πυρομαχικά, φωτίζοντας με ή χωρίς ρήγμα, διαρροή γόμωσης ή προωθητικής γόμωσης	   "  ,"")   
clv2.AddTextItem("0299	 Κατηγορία 1	ΒΟΜΒΕΣ, φλας	   "  ,"")   
clv2.AddTextItem("0300	 Κατηγορία 1	Πυρομαχικά, εμπρηστικά με ή χωρίς ρήγμα, διαρροή γόμωσης ή προωθητικής γόμωσης	 "  ,"")   

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
