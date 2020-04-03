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
	Private Button1 As Button
Dim txt As EditText

	
   Dim s As String
	Private Button2 As Button
	Private Button3 As Button
	Private Button4 As Button
    Dim ImageView1 As ImageView
End Sub

Sub Activity_Create(FirstTime As Boolean)
	  Activity.LoadLayout("main")
	
	
	ImageView1.top = 0%y
	ImageView1.left = 0%x
	ImageView1.width = 100%x
	ImageView1.height = 100%y
	
		Button2.top = 20%y
	Button2.left = 20%x
	Button2.width = 60%x
	Button2.height = 15%y
	
	Button1.top = 40%y
	Button1.left = 20%x
	Button1.width = 60%x
	Button1.height = 15%y
	
	Button3.top = 60%y
	Button3.left = 20%x
	Button3.width = 60%x
	Button3.height = 15%y

	Button4.top = 80%y
	Button4.left = 20%x
	Button4.width = 60%x
	Button4.height = 15%y
	
	
	
	
	
	
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub
Sub Button3_Click
Msgbox("Η εφαρμογή αποθηκεύει αυτόματα την τελευταία τοποθεσία gps","")
Msgbox("Την πρώτη φορά ενδέχεται να καθηστερήσει η εύρεση δορυφόρων ανάλογα με τον δέκτη κάθε κινητού τηλεφώνου ","")
Msgbox("Ο αριθμός που εμφανίζεται είναι κατα σειρά Μόιρες:Λέπτα:Δευτερόλεπτα (xx:xx:xx.xxx)","")
Msgbox("Για την μεταφορά τον συντεταγμένων στον χάρτη πιθανόν να χρειαστεί να αντικατασταθεί το κόμμα στα δευτερόλεπτα με τελεία ","Αλλαγή απο xx,xxx σε xx.xxx")
End Sub
Sub Button2_Click
	StartActivity("Main")
End Sub
Sub Button1_Click
	Msgbox(File.ReadString(File.DirRootExternal, "gpsfire.txt"), s)
End Sub
Sub Button4_Click
	Activity.Finish
End Sub

