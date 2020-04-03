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
	


	
	Dim clv2 As CustomListView
	
	Dim Panel2 As Panel
	



	
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("lipothimia.bal")

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

   clv2.AddTextItem("Ο βασικότερος λόγος της λιποθυμίας είναι η αιφνίδια μείωση της παροχής αίματος στον εγκέφαλο ή πτώση του σακχάρου", "")
clv2.AddTextItem("Έπειτα το θύμά έχει υποτονία και  απώλεια συνείδησης, συνήθως για σύντομο χρονικό διάστημα", "")
clv2.AddTextItem("Συμπτώματα της λιποθυμίας είναι η μυηκή αδυναμία με έντονη εφίδρωση, ωχρότητα του προσώπου, ναυτία και ταχυκαρδία με επιτάχυνση της αναπνοής", "")
clv2.AddTextItem("Οι αιτίες λιποθυμίας είναι η υπογλυκαιμία, η αφυδάτωση, ο τραυματισμός της κεφαλής, και οι καρδιολογικές παθήσεις ", "")
clv2.AddTextItem("Αντιμετώπηση της λυποθυμίας", "")
clv2.AddTextItem("Διαπιστώστε ότι δεν υπάρχει απόφραξη αεροφόρων οδών από τη γλώσσα που δεν είναι γυρισμένη προς τα πίσω και ότι δεν υπάρχει τροφή ή εμέσματα στο στόμα.", "")
clv2.AddTextItem("Χαλαρώστε τα ρούχα, γραβάτες, ζώνες, που μπορούν να εμποδίζουν τη φυσιολογική αναπνοή.", "")
clv2.AddTextItem("Εάν η λυποθυμία ή τα σύμπτώματα της οφείλοντε σε έντονο ψυχικό στρες-κρίση πανικού, προσπαθείστε να το ηρεμήσετε και καθησυχάστε το", "")
clv2.AddTextItem("Σήκωστε τα πόδια του πάνω από το επίπεδο της καρδιάς.", "")
clv2.AddTextItem("Κράτηστέ το θύμα ξαπλωμένο για τουλάχιστον 10 – 15 λεπτά.", "")
clv2.AddTextItem("Χαλάρωσε τα ρούχα του γύρω από το λαιμό και την κοιλιά.", "")
clv2.AddTextItem("Έλεγξε την αναπνοή και τον σφυγμό του. ", "")
clv2.AddTextItem("Μη δώσετε νερό ή τροφής, καφέ και αλκοόλ σε κάποιον ενώ είναι λιπόθυμος. Περιμένετε να συνέλθει και δώστε χυμό.", "")
clv2.AddTextItem("Αν για τη λιποθυμία ευθύνεται η ζέστη φρόντιστε να μεταφερθεί σε δροσερό μέρος και να δροσιστεί με βρεγμένα πανιά.", "")
clv2.AddTextItem("Ακόμα και εάν δεν πρόκειται για επείγουσα κατάσταση, το θύμα θα πρέπει εξεταστελι απο γιατρό ειδικά αν έχει λιποθυμήσει ξανά στο παρελθόν", "")

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
