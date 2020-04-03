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

 
clv2.AddTextItem("0301	 Κατηγορία 3	Πυρομαχικά , δάκρυ-παραωή με ρήμα, διαρροή όμωσης ή προωθητικής όμωσης	" ,"")
clv2.AddTextItem("0303	 Κατηγορία 3	Πυρομαχικά, καπνό, με ή χωρίς ρήμα, διαρροή όμωσης ή προωθητικής όμωσης	   " ,"")
clv2.AddTextItem("0305	 Κατηγορία 3	Πούδρα λάμψης	   " ,"")
clv2.AddTextItem("0306	 Κατηγορία 3	Ιχνηλάτες ια τα πυρομαχικά	   " ,"")
clv2.AddTextItem("0312	 Κατηγορία 3	Φυσίια , σήμα	   " ,"")
clv2.AddTextItem("0313	 Κατηγορία 2. 3	Σήματα, καπνός	   " ,"")
clv2.AddTextItem("0314	 Κατηγορία 2.3	Αναφλεκτηρες	   " ,"")
clv2.AddTextItem("0315	 Κατηγορία 3	Αναφλεκτηρες	   " ,"")
clv2.AddTextItem("0316	 Κατηγορία 3	Ασφάλειες, πυροδοτώντας	   " ,"")
clv2.AddTextItem("0317	 Κατηγορία 3	Ασφάλειες, πυροδοτώντας	   " ,"")
clv2.AddTextItem("0318	 Κατηγορία 3	Χειροομίδες, πρακτική, χειρός ή όπλου	   " ,"")
clv2.AddTextItem("0319	 Κατηγορία 3	Αστάρια, σωληνοειδή	   " ,"")
clv2.AddTextItem("0320	 Κατηγορία 3	Αστάρια, σωληνοειδή	   " ,"")
clv2.AddTextItem("0321	 Κατηγορία 1. 2	ΦΥΣΥΓΚΙΑ, ΟΠΛΑ, με εκρηκτική όμωση	   " ,"")
clv2.AddTextItem("0322	 Κατηγορία 2	Πυραυλοκινητήρες με υπερολικών υρά με ή χωρίς διαρροή όμωσης	   " ,"")
clv2.AddTextItem("0323	 Κατηγορία 4	Φυσίια, συσκευή ηλεκτρικής ενέρειας	   " ,"")
clv2.AddTextItem("0324	 Κατηγορία 4	ΛΗΜΑΤΑ, με εκρηκτική όμωση	   " ,"")
clv2.AddTextItem("0325	 Κατηγορία 3	Αναφλεκτηρες	   " ,"")
clv2.AddTextItem("0326	 Κατηγορία 1.1	Φυσιγγια όπλα, κενό	   " ,"")
clv2.AddTextItem("0327	 Κατηγορία 1.3	Φυσιγγια όπλα, κενό ή Φυσίια, μικρών όπλων, κενό	   " ,"")
clv2.AddTextItem("0328	 Κατηγορία 1.2	Φυσιγγια όπλα, αδρανούς λήματος	   " ,"")
clv2.AddTextItem("0329	Κατηγορία 1.1	Τορπίλες με εκρηκτική όμωση	      " ,"")
clv2.AddTextItem("0330	 Κατηγορία 1.1	Τορπίλες με εκρηκτική όμωση	      " ,"")
clv2.AddTextItem("0331	 Κατηγορία 1.5	Εκρηκτικό, ανατινάξεις, τύπου  (εκπρόσωπος, ανατινάξεις τύπου )   " ,"")	   
clv2.AddTextItem("0332	 Κατηγορία 1.5	Εκρηκτικό, ανατινάξεις, τύπου Ε (εκπρόσωπος, ανατινάξεις, τύπου Ε)	   " ,"")   
clv2.AddTextItem("0333	 Κατηγορία 1.1	Πυροτεχνήματα	      " ,"")
clv2.AddTextItem("0334	 Κατηγορία 2.3	Πυροτεχνήματα	      " ,"")
 clv2.AddTextItem("0335	 Κατηγορία 3	Πυροτεχνήματα	      " ,"")
 clv2.AddTextItem("0336,	 Κατηγορία 3	Πυροτεχνήματα	      " ,"")
clv2.AddTextItem("0337	 Κατηγορία 4	Πυροτεχνήματα	      " ,"")
clv2.AddTextItem("0338	 Κατηγορία 1.4	Φυσιγγια όπλα, κενό ή Φυσίια, μικρών όπλων, κενό	      " ,"")
clv2.AddTextItem("0339	 Κατηγορία 1.4	Φυσιγγια όπλα, αδρανούς λήματος ή Φυσίια, μικρών όπλων	      " ,"")
clv2.AddTextItem("0340	Κατηγορία 1.1	Νιτροκυτταρίνη , ξηρός ή νωπός με λιότερο από 25 τοις εκατό νερό (ή οινόπνευμα), με μάζα	    " ,"")  
clv2.AddTextItem("0341	Κατηγορία 1.1	Νιτροκυτταρίνη, μη τροποποιημένα ή πλαστικοποιημένο      " ,"")
clv2.AddTextItem("0342	 Κατηγορία 1.3	Νιτροκυτταρίνη, ρεμένο με όχι λιότερο από 25 τοις εκατό αλκοόλη, κατά άρος	      " ,"")
clv2.AddTextItem("0343	 Κατηγορία 1.3	Νιτροκυτταρίνη, πλαστικοποιημένο με όχι λιότερο από 18 τοις εκατό πλαστικοποίησης ουσία, κατά μάζα	      " ,"")
clv2.AddTextItem("0344	 Κατηγορία 1.4	ΛΗΜΑΤΑ, με εκρηκτική όμωση	   " ,"")
clv2.AddTextItem("0345	 Κατηγορία 4	λήματα, αδρανή με ιχνηθέτη" ,"")
clv2.AddTextItem("0346	 Κατηγορία 1.2	ΛΗΜΑΤΑ, με διαρρήκτη ή διαρροή όμωσης" ,"")
clv2.AddTextItem("0347	 Κατηγορία 1.4	ΛΗΜΑΤΑ, με διαρρήκτη ή διαρροή όμωσης" ,"")
clv2.AddTextItem("0348	 Κατηγορία 1.4	ΦΥΣΙΙΑ ΙΑ ΟΠΛΑ, με εκρηκτική όμωση" ,"")
clv2.AddTextItem("0349	 Κατηγορία 4	Άρθρα, εκρηκτικά, NOS" ,"")
clv2.AddTextItem("0350	 Κατηγορία 1.4	Άρθρα, εκρηκτικά, NOS" ,"")
clv2.AddTextItem("0351	 Κατηγορία 1.4	Άρθρα, εκρηκτικά, NOS" ,"")
clv2.AddTextItem("0352	 Κατηγορία 1.4	Άρθρα, εκρηκτικά, NOS" ,"")
clv2.AddTextItem("0353	 Κατηγορία 3	Άρθρα, εκρηκτικά, NOS" ,"")
clv2.AddTextItem("0354	 Κατηγορία 1.1	Άρθρα, εκρηκτικά, NOS" ,"")
clv2.AddTextItem("0355	 Κατηγορία 2	Άρθρα, εκρηκτικά, NOS" ,"")
clv2.AddTextItem("0356	 Κατηγορία 1.3	Άρθρα, εκρηκτικά, NOS" ,"")
clv2.AddTextItem("0357	 Κατηγορία 1.1	Ουσίες, εκρηκτικά, NOS" ,"")
clv2.AddTextItem("0358	 Κατηγορία 2	Ουσίες, εκρηκτικά, NOS" ,"")
clv2.AddTextItem("0359	 Κατηγορία 1.3	Ουσίες, εκρηκτικά, NOS" ,"")
clv2.AddTextItem("0360	 Κατηγορία 1.1	Συνδεσμολοίες πυροκροτητών, μη ηλεκτρικές ια ανατινάξεις" ,"")
clv2.AddTextItem("0361	 Κατηγορία 1.4	Συνδεσμολοίες πυροκροτητών, μη ηλεκτρικές ια ανατινάξεις" ,"")
clv2.AddTextItem("0362	 Κατηγορία 3	Πυρομαχικά, πρακτική" ,"")
clv2.AddTextItem("0363	 Κατηγορία 3	Πυρομαχικά, απόδειξη" ,"")
clv2.AddTextItem("0364	 Κατηγορία 1.2	Πυροκροτητές ια τα πυρομαχικά" ,"")
clv2.AddTextItem("0365	 Κατηγορία 1.4	Πυροκροτητές ια τα πυρομαχικά" ,"")
clv2.AddTextItem("0366	 Κατηγορία 4	Πυροκροτητές ια τα πυρομαχικά" ,"")
clv2.AddTextItem("0367	 Κατηγορία 4	Ασφάλειες, εκρηκτικών" ,"")
clv2.AddTextItem("0368	 Κατηγορία 4	Ασφάλειες, ανάφλεξη" ,"")
clv2.AddTextItem("0369	 Κατηγορία 1.1	Κεφαλές , ρόκα με εκρηκτική όμωση" ,"")
clv2.AddTextItem("0370	 Κατηγορία 1.4	Κεφαλές, ρόκα με διαρρήκτη ή διαρροή όμωσης" ,"")
clv2.AddTextItem("0371	 Κατηγορία 1.4	Κεφαλές, ρόκα με διαρρήκτη ή διαρροή όμωσης" ,"")
clv2.AddTextItem("0373	 Κατηγορία 4	Συσκευές σηματοδότησης, χέρι" ,"")
clv2.AddTextItem("0374	 Κατηγορία 1.1	Υροδείκτες, εκρηκτικά" ,"")
clv2.AddTextItem("0375	 Κατηγορία 1.2	Υροδείκτες, εκρηκτικά" ,"")
clv2.AddTextItem("0376	 Κατηγορία 4	Αστάρια, σωληνοειδή" ,"")
clv2.AddTextItem("0377	 Κατηγορία 1.1	Αστάρια, τύπος καπάκι" ,"")
clv2.AddTextItem("0378	 Κατηγορία 1.4	Αστάρια, τύπος καπάκι" ,"")
clv2.AddTextItem("0379	 Κατηγορία 1.4	Θήκες, φυσίια, άδειο, με αστάρι" ,"")
clv2.AddTextItem("0380	 Κατηγορία 2	Άρθρα, πυροφορικά" ,"")
clv2.AddTextItem("0381	 Κατηγορία 1.2	Φυσίια, συσκευή ηλεκτρικής ενέρειας" ,"")
clv2.AddTextItem("0382	 Κατηγορία 1.2	Εξαρτήματα, εκρηκτικών, NOS	   " ,"")
clv2.AddTextItem("0383	 Κατηγορία 1.4	Εξαρτήματα, εκρηκτικών, NOS" ,"")
clv2.AddTextItem("0384	 Κατηγορία 4	Εξαρτήματα, εκρηκτικών, NOS" ,"")
clv2.AddTextItem("0385	Κατηγορία 1.1	5-Nitrobnzotriazo" ,"")
clv2.AddTextItem("0386	Κατηγορία 1.1	Τρινιτροενζολοσουλφονικό οξύ" ,"")
clv2.AddTextItem("0387	Κατηγορία 1.1	Τρινιτροφθορενόνη" ,"")
clv2.AddTextItem("0388	Κατηγορία 1.1	Τρινιτροτολουένιο (TNT) και τρινιτροενζενίου μείμα ή τρινιτροτολουολίου (TNT) και μίμα hxanitrostibn" ,"")
clv2.AddTextItem("0389	Κατηγορία 1.1	Τρινιτροτολουολίου (TNT) που περιέχει τρινιτροενζολο και Hxanitrostibn" ,"")
clv2.AddTextItem("0390	Κατηγορία 1.1	ΤΡΙΤΟΝΑΛΗ" ,"")
clv2.AddTextItem("0391	Κατηγορία 1.1	Κυκλοτριμεθυλενοτρινιτραμίνη" ,"")
clv2.AddTextItem("0392	Κατηγορία 1.1	Hxanitrostibn" ,"")
clv2.AddTextItem("0393	Κατηγορία 1.1	ΕΞΟΤΟΝΑΛΗ" ,"")
clv2.AddTextItem("0394	Κατηγορία 1.1	Trinitrorsorino (στυφνικό οξύ)" ,"")
clv2.AddTextItem("0396	 Κατηγορία 1.3J	Πυραυλοκινητήρες, υρό τροφοδοτείται" ,"")
clv2.AddTextItem("0397	 Κατηγορία 1.1J	Πύραυλοι, υρό τροφοδοτούνται με εκρηκτική γόμωση" ,"")
clv2.AddTextItem("0398	 Κατηγορία 1.2J	Πύραυλοι, υρό τροφοδοτούνται με εκρηκτική γόμωση" ,"")
clv2.AddTextItem("0399	 Κατηγορία 1.1J	όμες με εύφλεκτο υρό, με εκρηκτική γόμωση" ,"")
clv2.AddTextItem("0400	 Κατηγορία 1.2J	όμες με εύφλεκτο υρό, με εκρηκτική γόμωση" ,"")

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


