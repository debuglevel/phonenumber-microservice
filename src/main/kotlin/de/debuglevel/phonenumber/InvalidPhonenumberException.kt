package de.debuglevel.phonenumber

class InvalidPhonenumberException(number: String, inner: Exception? = null) :
    Exception("The phone number '$number' is invalid.", inner)