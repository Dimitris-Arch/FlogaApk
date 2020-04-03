Type=Activity
Version=3.5
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
	Dim pin1 As ImageView
	Dim pin2 As ImageView
	Dim pin3 As ImageView
	Dim pin4 As ImageView




	Dim Panel As Panel
	
	Dim clv2 As CustomListView
	
	Dim Panel2 As Panel
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("enabal.bal")
     

   
pin1.Visible = False
pin2.Visible = False
pin3.Visible = False
	

	
	 pin4.Top = 0%y
	pin4.Left =33.3%x
	pin4.Width = 25%x
	pin4.Height = 20%y
	
	
	
	pin1.BringToFront
	
	
	

	
	
	
	
  
  
  	clv2.Initialize(Me, "clv2")
	Panel2.AddView(clv2.AsView, 0, 0,100%x ,80%y )
	 Panel2.Top = 20%y
  Panel2.Left = 0%x
  Panel2.Width = 100%x
  Panel2.Height = 80%y
	clv2.DefaultTextBackgroundColor = Colors.Red
	
    clv2.AddTextItem("1.6 Εξαιρετικά μη ευαίσθητα είδη που δεν έχουν κίνδυνο μαζικής έκρηξης. Τα είδη περιέχουν μόνο εξαιρετικά μη ευαίσθητες εκρηκτικές ουσίες και εμφανίζουν αμελητέα πιθανότητα τυχαίας πυροδότησης ή εξάπλωσης.", "")
	clv2.AddTextItem("ΚΙΝΔΥΝΟΙ", "")
	clv2.AddTextItem("Θραύσματα και εκτινασσόμενα αντικείμενα σε 500-1.600 μέτρα ή περισσότερο εάν η φωτιά επεκταθεί στο φορτίο εκρηκτικών. Επίσης κίνδυνοι από ωστικό κύμα, πυρκαγιά, λάμψη, κρότο,καπνό, ανάπτυξη υψηλών θερμοκρασιών. Η πυρκαγιά μπορεί να παράγει ερεθιστικά, διαβρωτικά ή και τοξικά αέρια. Κατά τη διάρκεια πιθανού χειρισμού εκρηκτικών ουσιών απαιτείται ιδιαίτερηπροσοχή, διότι παρουσιάζουν ευαισθησία σε τριβή, κρούση, απότομες κινήσεις, δονήσεις, τράνταγμα, άνοδο θερμοκρασίας, σπινθήρες, φωτιά, στατικό ηλεκτρισμό.", "")
	clv2.AddTextItem("ΓΕΝΙΚΕΣ ΟΔΗΓΙΕΣ ΑΝΤΙΜΕΤΩΠΙΣΗΣ ΣΥΜΒΑΝΤΟΣ", "")
	clv2.AddTextItem("• Ενημερώστε το Κέντρο Επιχειρήσεων του Πυροσβεστικού Σώματος.• Διατηρήστε ικανή απόσταση ασφαλείας. Συνδράμετε την Ελληνική Αστυνομία (ΕΛ.ΑΣ.) για τον αποκλεισμό του χώρου ατυχήματος σε όλες τις κατευθύνσεις, ανάλογα με την επικινδυνότητα και την ποσότητα των εκρηκτικών, αρχικά σε ακτίνα 100-800 μέτρων για διασκορπισμό ήπυρκαγιά και σε ακτίνα 1.600 μέτρων σε όλες τις κατευθύνσεις όταν καίγονται εκρηκτικά όπως βόμβες και βλήματα πυροβολικού. Εξετάστε την εισήγησή σας στην αρμόδια Αρχή για εκκένωση/οργανωμένη απομάκρυνση των πολιτών.• Επιχειρήστε από την πλευρά που φυσά ο άνεμος (ανάντη, δηλαδή έχοντας τον άνεμο στην πλάτη στραμμένοι προς το περιστατικό). Καλυφθείτε σε ασφαλές σημείο (ανάχωμα, εμπόδιο κλπ.).", "")
	clv2.AddTextItem("• Σταματήστε να περιορίζετε τη φωτιά που βρίσκεται σε εξέλιξη όταν φτάσει στο φορτίο και απομακρυνθείτε, αν προηγουμένως δεν έχετε εξασφαλίσει πλήρη κάλυψη. Το φορτίο μπορεί να εκραγεί.• Μην αγγίζετε και μην περπατάτε στο διασκορπισμένο υλικό. Μη μετακινείτε το φορτίο ή το όχημα εάν το φορτίο έχει εκτεθεί σε αυξημένη θερμοκρασία.• Χρησιμοποιήστε πολύ νερό. Πλημμυρίστε το. Εάν δεν υπάρχει νερό χρησιμοποιήστε CO2 ή ξηρά σκόνη. Εάν είναι δυνατό, χρησιμοποιήστε μη επανδρωμένους, φορητούς, επιδαπέδιους αυλούς, τηλεκατευθυνόμενους αυλούς κ.α. από τη μεγαλύτερη δυνατή απόσταση για να εμποδίσετε την πυρκαγιά να φτάσει στο φορτίο.• Ζητήστε τη βοήθεια ειδικού. Μη χειρίζεστε το διασκορπισμένο εκρηκτικό εκτός εάν υπάρχει επίβλεψη από ειδικό.• Αποφύγετε να χυθούν τα υγρά πυρόσβεσης σε δίκτυα αποχέτευσης και υδάτινους πόρους.Αν χρειαστεί δημιουργήστε ανάχωμα για να συγκεντρώσετε τα παραπάνω υγρά ώστε να διατεθούν κατάλληλα. Μη διασκορπίζετε το «χυμένο» υλικό με συμπαγή βολή νερού κ.α.", "")
	clv2.AddTextItem("• Εξαλείψτε κάθε πηγή/εστία ανάφλεξης (τσιγάρα, φλόγες, σπινθήρες κ.α.). Μη χρησιμοποιείτε ασυρμάτους/κινητά τηλέφωνα εντός 100 μέτρων. Χρησιμοποιήστε εργαλεία που δεν δημιουργούν σπινθήρα. Ο εξοπλισμός που χρησιμοποιείται για το χειρισμό των εκρηκτικών πρέπει να είναι γειωμένος.• Φροντίστε για την προσωπική σας ασφάλεια και χρησιμοποιείστε κράνος, γυαλιά, γάντια,επενδύτη πυρκαγιάς, κουκούλα πυρκαγιάς, μπότες, αναπνευστική συσκευή θετικής πίεσης κ.α. ως μέσα ατομικής προστασίας.", "")

 
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
Sub pin4_Click
	Dim result As Int
result = Msgbox2("Επιστροφή στο μενού", "  ", "Ναί ", "  ", "Όχι ", LoadBitmap (File.DirAssets, "1.6.png"))
	If result = DialogResponse.Positive Then
	StartActivity("ilika")
	End If
End Sub

