from google.protobuf.internal import enum_type_wrapper as _enum_type_wrapper
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from typing import ClassVar as _ClassVar, Optional as _Optional, Union as _Union

DESCRIPTOR: _descriptor.FileDescriptor

class LampType(int, metaclass=_enum_type_wrapper.EnumTypeWrapper):
    __slots__ = ()
    ON_OFF: _ClassVar[LampType]
    BRIGHTNESS: _ClassVar[LampType]
ON_OFF: LampType
BRIGHTNESS: LampType

class LampRequest(_message.Message):
    __slots__ = ("id", "value")
    ID_FIELD_NUMBER: _ClassVar[int]
    VALUE_FIELD_NUMBER: _ClassVar[int]
    id: str
    value: int
    def __init__(self, id: _Optional[str] = ..., value: _Optional[int] = ...) -> None: ...

class LampResponse(_message.Message):
    __slots__ = ("message",)
    MESSAGE_FIELD_NUMBER: _ClassVar[int]
    message: str
    def __init__(self, message: _Optional[str] = ...) -> None: ...

class LampInfoRequest(_message.Message):
    __slots__ = ("id",)
    ID_FIELD_NUMBER: _ClassVar[int]
    id: str
    def __init__(self, id: _Optional[str] = ...) -> None: ...

class LampInfoResponse(_message.Message):
    __slots__ = ("id", "type", "value")
    ID_FIELD_NUMBER: _ClassVar[int]
    TYPE_FIELD_NUMBER: _ClassVar[int]
    VALUE_FIELD_NUMBER: _ClassVar[int]
    id: str
    type: LampType
    value: int
    def __init__(self, id: _Optional[str] = ..., type: _Optional[_Union[LampType, str]] = ..., value: _Optional[int] = ...) -> None: ...
