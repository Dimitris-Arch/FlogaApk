﻿B4A=true
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
	Activity.LoadLayout("katagma.bal")
	
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


               
clv2.AddTextItem("Κάταγμα είναι ένα σπασμένο οστό . Απαιτεί ιατρική φροντίδα . Αν το σπασμένο οστό είναι το αποτέλεσμα σοβαρού τραυματισμού ή ζημιάς , καλέστε το 166.", "")
clv2.AddTextItem("Το άκρο του τραυματισμένου χεριού ή του ποδιού , όπως ένα δάχτυλο του ποδιού ή των δακτύλων , είναι μουδιασμένο ή μπλε στην άκρη .", "")
clv2.AddTextItem("Ακόμη και απαλή πίεση ή κίνηση προκαλεί πόνο .", "")
clv2.AddTextItem("Μην μετακινείτε το άτομο , εκτός εάν είναι απαραίτητο για να αποφευχθεί η περαιτέρω ζημία . Πάρτε τις δράσεις αυτές αμέσως , ενώ περιμένετε για ιατρική βοήθεια :", "")
clv2.AddTextItem("Σταματήστε οποιαδήποτε αιμορραγία . Ασκήστε πίεση στην πληγή με έναν αποστειρωμένο επίδεσμο , ένα καθαρό πανί ή με ένα καθαρό ρούχο .", "")
clv2.AddTextItem("Ακινητοποιήστε την τραυματισμένη περιοχή . ", "")
clv2.AddTextItem("Μην προσπαθήσετε να σπρώξετε το οστό ή ένα κόκαλο έχει βγεί. ", "")
clv2.AddTextItem("Εφαρμόστε ένα νάρθηκα στην περιοχή πάνω και κάτω από τις θέσεις του κατάγματος . Μπορεί να βοηθήσει να μειωθεί ο πόνος .", "")
clv2.AddTextItem("Εφαρμόστε παγοκύστες για να περιορίσει το πρήξιμο και να βοηθήσει να ανακουφίσει τον πόνο μέχρι να έρθει το προσωπικό έκτακτης ανάγκης . Μην εφαρμόζετε πάγο απευθείας στο δέρμα - τυλίξτε τον πάγο σε μια πετσέτα , κομμάτι ύφασμα ή κάποιο άλλο υλικό .", "")
clv2.AddTextItem("Πάρτε μέτρα για σοκ . Αν το άτομο αισθάνεται λιποθυμία ή αναπνέει με λίγα λόγια, γρήγορες αναπνοές , τοποθετείστε το πρόσωπο προς τα κάτω με το κεφάλι ελαφρώς χαμηλότερα από τον κορμό και , αν είναι δυνατόν , να ανυψώσει τα πόδια .", "")
clv2.AddTextItem("Ενθαρρύνετε το άτομο να υποστηρίξει τη ζημία με το χέρι του , ή να χρησιμοποιήσετε ένα μαξιλάρι ή τα είδη ένδυσης για την αποφυγή περιττής κίνησης .", "")
clv2.AddTextItem("Το συντομότερο δυνατόν , καλέστε το 166, εάν είναι σοβαρό το περιστατικό.", "")
clv2.AddTextItem("Συνεχίστε την υποστήριξη της ζημίας μέχρι να έρθει βοήθεια .", "")

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
