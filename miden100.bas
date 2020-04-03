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

 
clv2.AddTextItem("0004	Κατηγορία 1.1D	Πικρικό αμμώνιο , ξηρός ή νωπός με λιγότερο από Κατηγορία 10 τοις εκατό νερό, κατά βάρος	     " ,"")
clv2.AddTextItem("0005	Κατηγορία 1.1E	Φυσίγγια για όπλα, με εκρηκτική γόμωση	     " ,"")
clv2.AddTextItem("0009	Κατηγορία 1	Πυρομαχικά , εμπρηστικά με ή χωρίς ρήγμα, διαρροή γόμωσης ή προωθητικής γόμωσης	     " ,"")
clv2.AddTextItem("0012	 Κατηγορία 1	Φυσίγγια για όπλα, αδρανούς βλήματος ή Φυσίγγια, μικρών όπλων	     " ,"")
clv2.AddTextItem("0014	 Κατηγορία 1	Φυσίγγια για όπλα, κενό ή Φυσίγγια, μικρών όπλων, κενό	     " ,"")
clv2.AddTextItem("0015 	 Κατηγορία 1	Πυρομαχικά, καπνό, με ή χωρίς ρήγμα, διαρροή γόμωσης ή προωθητικής γόμωσης	     " ,"")
clv2.AddTextItem("0018	 Κατηγορία 1	Πυρομαχικά, δάκρυ-παραγωγή με ρήγμα, διαρροή γόμωσης ή προωθητικής γόμωσης	     " ,"")
clv2.AddTextItem("0020 	 Κατηγορία 1	Πυρομαχικά, τοξικά με ρήγμα, διαρροή γόμωσης ή προωθητικής γόμωσης	     " ,"")
clv2.AddTextItem("0027	 Κατηγορία 1	Μαύρη σκόνη ή Μπαρούτι, κοκκώδης ή ως ένα γεύμα	     " ,"")
clv2.AddTextItem("0028	 Κατηγορία 1	Μαύρη σκόνη, συμπιεσμένα ή Μπαρούτι, συμπιεσμένα ή Μαύρη σκόνη, σε σφαιρίδια ή Μπαρούτι, σε σφαιρίδια	     " ,"")
clv2.AddTextItem("0029 	 Κατηγορία 1	Πυροκροτητές , ηλεκτρικά είδη, μη ηλεκτρικά, για ανατινάξεις	     " ,"")
clv2.AddTextItem("0033 	 Κατηγορία 1	Βόμβες , με εκρηκτική γόμωση	     " ,"")
clv2.AddTextItem("0037 	 Κατηγορία 1	ΒΟΜΒΕΣ, φλας	     " ,"")
clv2.AddTextItem("0042	 Κατηγορία 1	Ενισχυτές , χωρίς πυροκροτητή  " ,"")	   
clv2.AddTextItem("0043	 Κατηγορία 1	Γάμα , εκρηκτικά	     " ,"")
clv2.AddTextItem("0044	 Κατηγορία 1	Αστάρια , τύπος καπάκι	     " ,"")
clv2.AddTextItem("0048	 Κατηγορία 1	Χρεώσεις , κατεδάφιση	     " ,"")
 clv2.AddTextItem("0049	 Κατηγορία 1	Φυσίγγια, φλας	     " ,"")
clv2.AddTextItem("0054	 Κατηγορία 1	Φυσίγγια, σήμα	     " ,"")
clv2.AddTextItem("0055	 Κατηγορία 1	Θήκες, φυσιγγίων, άδειο, με αστάρι	  " ,"")   
clv2.AddTextItem("0056	 Κατηγορία 1	Χρεώσεις, το βάθος	     " ,"")
clv2.AddTextItem("0059	 Κατηγορία 1	Χρεώσεις, σχήμα, χωρίς πυροκροτητή	  " ,"")   
clv2.AddTextItem("0060	 Κατηγορία 1	Χρεώσεις, συμπληρωματική εκρηκτικά	     " ,"")
clv2.AddTextItem("0065	 Κατηγορία 1	Καλώδιο , εκρηκτικών, ευέλικτη	     " ,"")
clv2.AddTextItem("0066	 Κατηγορία 1	Καλώδιο, ανάφλεξη	       " ,"")
clv2.AddTextItem("0070	 Κατηγορία 1	Κόφτες, καλώδιο, εκρηκτικά  " ,"")	   
clv2.AddTextItem("0072	 Κατηγορία 1	Κυκλοτριμεθυλενοτρινιτραμίνη   " ,"")
clv2.AddTextItem("0073	 Κατηγορία 1	Πυροκροτητές για τα πυρομαχικά	  " ,"")   
clv2.AddTextItem("0074	 Κατηγορία 1	Diazodinitrophenol , βρεγμένο με όχι λιγότερο από 40 τοις εκατό νερό ή μίγμα αλκοόλης και νερού, κατά βάρος	  " ,"")   
clv2.AddTextItem("0075	 Κατηγορία 1	Διαιθυλενογλυκόλη δινιτρικό  " ,"")
clv2.AddTextItem("0076	 Κατηγορία 1	Δινιτροφαινόλης , ξηρός ή νωπός με λιγότερο από Κατηγορία 15 τοις εκατό νερό κατά μάζα	     " ,"")
clv2.AddTextItem("0077	 Κατηγορία 1	Dinitrophenolates αλκαλικά μέταλλα , ξηρός ή νωπός με λιγότερο από Κατηγορία 15 τοις εκατό νερό κατά μάζα  " ,"")	   
clv2.AddTextItem("0078	 Κατηγορία 1	Dinitroresorcinol , ξηρός ή νωπός με λιγότερο από Κατηγορία 15 τοις εκατό νερό κατά μάζα	     " ,"")
clv2.AddTextItem("0079	 Κατηγορία 1	Hexanitrodiphenylamine ή Dipicrylamine ή Hexyl	     " ,"")
clv2.AddTextItem("0081	 Κατηγορία 1	Εκρηκτικό , ανατινάξεις, τύπου Α	     " ,"")
clv2.AddTextItem("0082	 Κατηγορία 1	Εκρηκτικό, ανατινάξεις, τύπου Β	  " ,"")   
clv2.AddTextItem("0083	 Κατηγορία 1	Εκρηκτικό, ανατινάξεις, τύπου C	  " ,"")   
clv2.AddTextItem("0084	 Κατηγορία 1	Εκρηκτικό, ανατινάξεις, τύπου D	  " ,"")   
clv2.AddTextItem("0092	 Κατηγορία 1	Φωτοβολίδες , επιφάνεια	     " ,"")
clv2.AddTextItem("0093	 Κατηγορία 1	Φωτοβολίδες, εναέρια	     " ,"")
clv2.AddTextItem("0094	 Κατηγορία 1	Blitzlichtpulver (Flash σκόνη, π.χ. για μια ντεμοντέ φλας της φωτογραφικής μηχανής)	  " ,"")   
clv2.AddTextItem("0099	 Κατηγορία 1	Συσκευές, εκρηκτικά, θραύση χωρίς πυροκροτητές για πετρελαιοπηγές	   " ,"")


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
