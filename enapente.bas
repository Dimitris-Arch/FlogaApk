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
	'These global variables will be redeclared each time the activity is created.

	
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
	Private cameraalabel As Label
	Private cameraaofflabel As Label
	Private gpsslabel As Label
	Private thllabel As Label
	Private pixilabel As Label
	Dim Panel As Panel
	
	Dim clv2 As CustomListView
	Dim pin1 As ImageView
	Dim pin2 As ImageView
	Dim pin3 As ImageView
	Dim pin4 As ImageView

	
	Dim Panel2 As Panel
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("ena5.bal")
	'PRWTO PANW aristera
pin1.Top = 3%y
pin1.left = 3%x
pin1.height = 28%y
pin1.Width  = 45%x
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

pin1.BringToFront
	
	
	
	

	
	
	
	
  
  
  	clv2.Initialize(Me, "clv2")
	Panel2.AddView(clv2.AsView, 0.5%x, 0%y,93%x ,57.5%y )
	 Panel2.Top = 33%y
  Panel2.Left = 3%x
  Panel2.Width = 94%x
  Panel2.Height = 57.5%y
	clv2.DefaultTextBackgroundColor = Colors.Red
clv2.AddTextItem("1.5 Ο κίνδυνος έκρηξης ή εκτίναξης είναι πολύ ελάχιστος.", "")
	
clv2.AddTextItem("ΚΡΑΤΗΣΤΕ ΠΑΝΤΑ ΑΠΌΣΤΑΣΗ ΑΣΦΑΛΕΊΑΣ.Αυλοί οροφής,εδάφους  ή αλλοί τηλεκατευθυνόμενοι είναι ιδανικοί", "")
clv2.AddTextItem("Άμεσος αποκλεισμός του χώρου σε απόσταση 100 εώς 800 μέτρων σε μικρή πυρκαγιά και σε περίπτωση μεγάλης απόσταση 1600 μέτρων", "")
clv2.AddTextItem("ΠΑΝΤΑ ΦΟΡΑΤΕ ΠΛΗΡΗ ΕΞΑΡΤΗΣΗ,κράνος,περισκελίδα,επενδύτη,γαντια και αναπνευστική συσκευή", "")
clv2.AddTextItem("Τα εργαλεία που χρησιμοποιούνται δεν θα πρέπει να προκαλούν σπινθήρες ή στατικό ηλεκτρισμό.Μην χρησιμοποιείτε κοντά στην φωτιά κινητά τηλέφωνα ή ασύρματο", "")
clv2.AddTextItem("Η προσβολή γίνετε απο την πλευρά που φυσάει ο άνεμος.Πάντα με την πλάτη στον άνεμο.Καλυφθείτε απο κάποιο εμπόδιο,τοίχο,όχημα ανάχωμα κτλ", "")
clv2.AddTextItem("Μήν διασκορπίζετε την πυρκαγιά με συμπαγή βολή,Αν είναι δυνατό καλύψτε με C02,ξηρά σκόνη ή αφρό", "")
clv2.AddTextItem("Κατάσβεση όλων των πηγών ανάφλεξης, ακόμα και τις μικρότερες.Επίσης πρέπει να επιχειρείται μείωση της θερμοκρασίας", "")
clv2.AddTextItem("Σταματήστε και απομακρυνθείτε εάν η φωτιά φτάσει στο βυτίο-δεξαμενή ή υπάρχει μεγάλη θερμοκρασία δίπλα που δεν εξουδετερώνεται ,υπάρχει μεγάλος κίνδυνος έκρηξης σε πολλές ουσίες της κατηγορίας", "")
clv2.AddTextItem("Προσπαθήστε να περιορίσετε την εξάπλωση της ουσίας στην φύση και στο περιβάλλον ", "")

 
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
Sub pin4_Click
	Dim result As Int
result = Msgbox2("Επιστροφή στο μενού", "  ", "Ναί ", "  ", "Όχι ", LoadBitmap (File.DirAssets, "1.6.png"))
	If result = DialogResponse.Positive Then
	StartActivity("ilika")
	End If
End Sub




Sub ili_Click
	StartActivity("Main")
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
	StartActivity("Main")
End Sub


Sub Activity_KeyPress (KeyCode As Int) As Boolean
    If KeyCode = KeyCodes.KEYCODE_BACK Then
      
             Activity.Finish
       End If
End Sub
