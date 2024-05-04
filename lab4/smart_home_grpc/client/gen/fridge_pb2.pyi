from google.protobuf.internal import enum_type_wrapper as _enum_type_wrapper
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from typing import ClassVar as _ClassVar, Optional as _Optional, Union as _Union

DESCRIPTOR: _descriptor.FileDescriptor

class ChamberType(int, metaclass=_enum_type_wrapper.EnumTypeWrapper):
    __slots__ = ()
    FRIDGE: _ClassVar[ChamberType]
    FREEZER: _ClassVar[ChamberType]
FRIDGE: ChamberType
FREEZER: ChamberType

class FridgeTemperatureRequest(_message.Message):
    __slots__ = ("id", "type", "value")
    ID_FIELD_NUMBER: _ClassVar[int]
    TYPE_FIELD_NUMBER: _ClassVar[int]
    VALUE_FIELD_NUMBER: _ClassVar[int]
    id: str
    type: ChamberType
    value: int
    def __init__(self, id: _Optional[str] = ..., type: _Optional[_Union[ChamberType, str]] = ..., value: _Optional[int] = ...) -> None: ...

class FridgeToggleRequest(_message.Message):
    __slots__ = ("id", "type", "value")
    ID_FIELD_NUMBER: _ClassVar[int]
    TYPE_FIELD_NUMBER: _ClassVar[int]
    VALUE_FIELD_NUMBER: _ClassVar[int]
    id: str
    type: ChamberType
    value: bool
    def __init__(self, id: _Optional[str] = ..., type: _Optional[_Union[ChamberType, str]] = ..., value: bool = ...) -> None: ...

class FridgeInfoRequest(_message.Message):
    __slots__ = ("id",)
    ID_FIELD_NUMBER: _ClassVar[int]
    id: str
    def __init__(self, id: _Optional[str] = ...) -> None: ...

class FridgeInfoResponse(_message.Message):
    __slots__ = ("id", "freezerOn", "fridgeOn", "freezerTemperature", "fridgeTemperature")
    ID_FIELD_NUMBER: _ClassVar[int]
    FREEZERON_FIELD_NUMBER: _ClassVar[int]
    FRIDGEON_FIELD_NUMBER: _ClassVar[int]
    FREEZERTEMPERATURE_FIELD_NUMBER: _ClassVar[int]
    FRIDGETEMPERATURE_FIELD_NUMBER: _ClassVar[int]
    id: str
    freezerOn: bool
    fridgeOn: bool
    freezerTemperature: int
    fridgeTemperature: int
    def __init__(self, id: _Optional[str] = ..., freezerOn: bool = ..., fridgeOn: bool = ..., freezerTemperature: _Optional[int] = ..., fridgeTemperature: _Optional[int] = ...) -> None: ...

class FridgeResponse(_message.Message):
    __slots__ = ("message",)
    MESSAGE_FIELD_NUMBER: _ClassVar[int]
    message: str
    def __init__(self, message: _Optional[str] = ...) -> None: ...
