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
Dim Panel As Panel
Dim Panel1 As Panel
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


Dim textpin1 As Label
Dim textpin2 As Label
Dim textpin3 As Label
Dim textpin4 As Label
Dim textpin5 As Label
Dim textpin6 As Label
Dim textpin7 As Label
Dim textpin8 As Label
Dim textpin9 As Label

Private ImageView0 As ImageView
	Private ImageView1 As ImageView
	Private ImageView2 As ImageView
	Private ImageView3 As ImageView
	Private ImageView4 As ImageView
	Private ImageView5 As ImageView
	Private ImageView6 As ImageView
	Private ImageView7 As ImageView
	Private ImageView8 As ImageView
	Private ImageView9 As ImageView


	
	Dim clv2 As CustomListView
	
	Dim Panel2 As Panel
	



	
End Sub

Sub Activity_Create(FirstTime As Boolean)
Activity.LoadLayout("aimoragia.bal")

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
	Panel2.AddView(clv2.AsView, 0.5%x, 0%y,93%x ,57.5%y )
	 Panel2.Top = 33%y
  Panel2.Left = 3%x
  Panel2.Width = 94%x
  Panel2.Height = 57.5%y
	clv2.DefaultTextBackgroundColor = Colors.DarkGray

   clv2.AddTextItem("Μετά τον έλεγχο της σκηνής και του τραυματισμένου ατόμου ", "")
clv2.AddTextItem("Ανυψώστε το μέλος που αιμορραγεί ψηλότερα από το επίπεδο της καρδιάς", "")
clv2.AddTextItem("Καθαρίστε καλα την περιοχη με αντισυπτικο υγρό,ξεπλύνετε και ξανακαθαρίστε", "")
clv2.AddTextItem("Καλύψτε το τραύμα με έναν αποστειρωμένο επίδεσμο ή καθαρό πανί αν δεν υπάρχει επίδεσμος .", "")
clv2.AddTextItem("Πίεση στο τράυμα μέχρι σταματήσει η αιμορραγία", "")
clv2.AddTextItem("Ελέγξτε για κυκλοφορία πέρα από τον τραυματισμό.", "")
clv2.AddTextItem("Αν η αιμορραγία δεν σταματά ", "")
clv2.AddTextItem("■ Καλέστε το 166, αν δεν έχει γίνει ήδη .", "")
clv2.AddTextItem("■ Εφαρμογή περισσότερων επιδέσμων .", "")
clv2.AddTextItem("■ Συνεχίστε πρόσθετες πιέσεις .", "")
clv2.AddTextItem("■ Να ληφθούν μέτρα για την ελαχιστοποίηση των κραδασμών .", "")
clv2.AddTextItem("ΣΥΜΒΟΥΛΗ  Πλύνετε τα χέρια σας καλά με σαπούνι και νερό μετά την παροχή φροντίδας", "")
clv2.AddTextItem("ΔΕΝ ΑΦΑΙΡΟΥΜΕ ΠΟΤΕ ΜΟΝΟΙ ΜΑΣ ΞΕΝΟ ΑΝΤΙΚΕΙΜΕΝΟ", "")
clv2.AddTextItem("Σε περίπτωση απλής ρυνορραγίας, πιέζουμε την μύτη για 10 λεπτά και βάζουμε το άτομο να σκύβει προς τα μπροστά.Όχι ανασήκωση του κεφαλιού, προς αποφυγή κατάποσης αίματος", "")
clv2.AddTextItem("Έπειτα φράζουμε την μύτη με πανί ή γάζα", "")
clv2.AddTextItem("Τριχοειδή αιμορραγία ", "")
clv2.AddTextItem("Το άιμα ρέει από το δέρμα λόγω εκδοράς.Δεν αποτελεί άμεσο κύνδινο για την υγεία", "")
clv2.AddTextItem("Φλεβική αιμορραγία", "")
clv2.AddTextItem("Το αίμα ρέει συνεχόμενα με σταθερή χαμηλή πίεση και το χρώμα είναι σκούρο κόκκινο", "")
clv2.AddTextItem("Αρτηριακή αιμορραγία", "")
clv2.AddTextItem("Το αίμα εκτόξευεται ανάλογα με τον ρυθμό της καρδιάς με μεγάλη πίεση και σε μεγάλη ποσότητα.Το χρώμα είναι έντονο κόκκινο", "")
clv2.AddTextItem("Εσωτερική αιμορραγία", "")
clv2.AddTextItem("Δεν είναι εμφανης αλλα είναι πολύ επικίνδυνη.Καλέστε το 166 ή μεταφέρετε  το θύμα στα επείγοντα αμέσως ", "")
clv2.AddTextItem("Συμπτώματα που μπορεί να υποδηλώνουν εσωτερική αιμορραγία", "")
clv2.AddTextItem("Βήχας με αφρώδες κόκκινο αίμα.", "")
clv2.AddTextItem("Εμετός με κόκκινο ή καφέ σκούρο υλικό.", "")
clv2.AddTextItem("Μαύρη κένωση ή κένωση με αίμα.", "")
clv2.AddTextItem("Καστανόμαυρα ή κόκκινα ούρα.", "")




End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)
Activity.Finish
End Sub
Sub ili_Click
	StartActivity("camera")
End Sub
Sub ousia_Click
	StartActivity("gpssignal")
End Sub
Sub pixi_Click
	StartActivity("pixida")
End Sub

Sub lista_Click
	StartActivity("thlefona")
End Sub

Sub katigor_Click
	StartActivity("pixida")
End Sub
Sub gpss_Click
	
StartActivity("gpssingal")
End Sub

Sub simanseislabel_Click
	StartActivity("karpa")
End Sub
Sub listabel_Click
	StartActivity("thlefona")
End Sub
Sub katigorlabel_Click
	StartActivity("pixida")
End Sub
Sub ousialabel_Click
	StartActivity("gpssignal")
End Sub
Sub ililabel_Click
	StartActivity("camera")
End Sub
Sub simansi_Click
	StartActivity("karpa")
End Sub
Sub Activity_KeyPress (KeyCode As Int) As Boolean
    If KeyCode = KeyCodes.KEYCODE_BACK Then
      
             Activity.Finish
       End If
End Sub

